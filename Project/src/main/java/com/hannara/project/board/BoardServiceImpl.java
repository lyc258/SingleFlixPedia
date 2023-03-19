package com.hannara.project.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao dao;

	@Override
	public BoardDto select(Integer board_seq) {
		BoardDto boardDto = dao.select(board_seq);
		dao.increaseViewCnt(board_seq);
		
		return boardDto;
	}

	@Override
	public List<BoardDto> selectList(BoardDto dto) {
		return dao.selectList(dto);
	}

	@Override
	public List<BoardDto> selectPage(Map map) {
		return dao.selectPage(map);

	}

	@Override
	public List<BoardDto> searchSelectPage(SearchHandler sc) {
		return dao.searchSelectPage(sc);
	}

	@Override
	public int searchCount(SearchHandler sc) {
		return dao.searchCount(sc);
	}

	@Override
	public int getCount() {
		return dao.getCount();
	}

	@Override
	public int increaseViewCnt(Integer board_seq) {
		return dao.increaseViewCnt(board_seq);
	}

	@Override
	public int insert(BoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(BoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(Integer board_seq) {
		return dao.delete(board_seq);
	}

}
