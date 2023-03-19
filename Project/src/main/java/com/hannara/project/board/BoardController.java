package com.hannara.project.board;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hannara.project.common.FileUploadUtil;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(MultipartFile.class, new PropertyEditorSupport());
	}

	@GetMapping(value = "/read")
	public String read(Integer board_seq, Model m, Integer page, Integer pageSize) {

		BoardDto boardDto = boardService.select(board_seq);

		m.addAttribute("boardDto", boardDto);
		m.addAttribute("page", page);
		m.addAttribute("pageSize", pageSize);

		return "board/board";
	}

	@GetMapping(value = "/list")
	public String list(SearchHandler sc, Integer page, Integer pageSize, Model m, Integer board_seq) {

		try {
			int totalCnt = boardService.searchCount(sc);
			m.addAttribute("totalCnt", totalCnt);

			PageHandler pageHandler = new PageHandler(totalCnt, sc);

			List<BoardDto> list = boardService.searchSelectPage(sc);
			m.addAttribute("list", list);
			m.addAttribute("ph", pageHandler);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "board/boardList";
	}

	@GetMapping(value = "/go_insert")
	public String insert(BoardDto dto, Model m, HttpSession session, RedirectAttributes rattr) {
		String writer = (String) session.getAttribute("member_id");
		dto.setWriter(writer);
		m.addAttribute("writer", writer);

		if (writer == null) {
			String msg = "NO_ID";
			rattr.addFlashAttribute("msg", msg);
			// m.addAttribute("msg", "ID_OK");
			return "redirect:/main";
		}

		return "board/insertboard";
	}

	@PostMapping(value = "/insert")
	String member_insert(BoardDto dto, HttpServletRequest request, HttpSession session,
			MultipartHttpServletRequest multi, RedirectAttributes rattr, Model m) {

		String writer = (String) session.getAttribute("member_id");
		dto.setWriter(writer);

		List<MultipartFile> multiList = new ArrayList<MultipartFile>();
		multiList.add(multi.getFile("upload"));

		List<String> fileNameList = new ArrayList<String>();
		String path = request.getServletContext().getRealPath("/");

		FileUploadUtil.upload(path, multiList, fileNameList);

		System.out.println(fileNameList);

		if (fileNameList.isEmpty()) {
			dto.setFileName("");
			boardService.insert(dto);
			return "redirect:/list";

		}

		try {
			dto.setFileName(fileNameList.get(0));
			if (boardService.insert(dto) != 1)
				throw new Exception("Insert Failed");
			rattr.addFlashAttribute("msg", "INSERT_OK");

		} catch (Exception e) {
			e.printStackTrace();

			rattr.addFlashAttribute("msg", "INSERT_ERROR");
			m.addAttribute("dto", dto);
			return "redirect:/board/insertboard.do";
		}

		return "redirect:/list";
	}

	@PostMapping(value = "/update")
	public String modify(Integer page, Integer pageSize, Model m, RedirectAttributes rattr, HttpSession session,
			BoardDto dto) {

		String writer = (String) session.getAttribute("member_id");
		dto.setWriter(writer);

		try {
			if (boardService.update(dto) != 1)
				throw new Exception("Update Error");
			rattr.addAttribute("page", page);
			rattr.addAttribute("pageSize", pageSize);
			rattr.addFlashAttribute("msg", "UPDATE_OK");
			return "redirect:/list";

		} catch (Exception e) {
			e.printStackTrace();
			rattr.addFlashAttribute("msg", "UPDATE_ERROR");
			m.addAttribute("dto", dto);

			return "redirect:/read";

		}

	}

	@PostMapping(value = "/delete")
	public String delete(Integer board_seq, Integer page, Integer pageSize, RedirectAttributes rattr,
			HttpSession session, Model m, BoardDto dto) {

		String writer = (String) session.getAttribute("member_id");
		dto.setWriter(writer);

		try {
			if (boardService.delete(board_seq) != 1)
				throw new Exception("Delete failed.");
			rattr.addAttribute("page", page);
			rattr.addAttribute("pageSize", pageSize);
			rattr.addFlashAttribute("msg", "DELETE_OK");
		} catch (Exception e) {
			e.printStackTrace();

		}

		return "redirect:/list";
	}
}
