package com.hannara.project.comment;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hannara.project.board.BoardDto;

@Controller
public class CommentController {
	@Autowired
	CommentService commentservice;

	@PostMapping("/project/comments")
	@ResponseBody
	public ResponseEntity<String> write(@RequestBody CommentDto dto, Integer board_seq, HttpSession session) {
		String writer = (String) session.getAttribute("member_id");
		dto.setWriter(writer);
		//System.out.println(writer);
		dto.setBoard_seq(board_seq);

		try {
			if (commentservice.insert(dto) != 1)
				throw new Exception("Comment Insert Error");

			return new ResponseEntity<String>("comment insert OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("comment insert Failed", HttpStatus.BAD_REQUEST);
	}

	@PatchMapping("/project/comments/{comment_seq}")
	@ResponseBody
	public ResponseEntity<String> update(@PathVariable Integer comment_seq, @RequestBody CommentDto dto,
			HttpSession session) {
		String writer = (String) session.getAttribute("member_id");
		dto.setWriter(writer);

//		dto.setComment(comment_modified);		
		dto.setComment_seq(comment_seq);

		try {
			if (commentservice.update(dto) != 1)
				throw new Exception("comment update failed.");

			return new ResponseEntity<>("댓글이 ", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("comment update error", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/project/comments/{comment_seq}")
	@ResponseBody
	public ResponseEntity<String> delete(@PathVariable Integer comment_seq, Integer board_seq, CommentDto dto,
			HttpSession session) throws Exception {
		String writer = (String) session.getAttribute("member_id");
		dto.setWriter(writer);

		try {
			int rowCnt = commentservice.delete(comment_seq, board_seq, writer);

			if (rowCnt != 1)
				throw new Exception("comment delete error");
			return new ResponseEntity<>("delete ok ", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("delete error ", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/project/comments") // /comments?bno=1080 GET
	@ResponseBody
	public ResponseEntity<List<CommentDto>> list(Integer board_seq, Model m) {
		List<CommentDto> listCno = null;
		try {
			listCno = commentservice.selectList(board_seq);

			m.addAttribute("listCno", listCno);
			return new ResponseEntity<List<CommentDto>>(listCno, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<CommentDto>>(HttpStatus.BAD_REQUEST);
		}
	}

}
