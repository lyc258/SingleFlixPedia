package com.hannara.project.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaolmpl implements BoardDao {
	@Autowired
	private SqlSessionTemplate sm;
	private static String namespace = "Board.";

	@Override
	public BoardDto select(Integer board_seq) {
		return sm.selectOne(namespace + "select", board_seq);
	}

	@Override
	public List<BoardDto> selectList(BoardDto dto) {
		return sm.selectList(namespace + "selectList", dto);
	}

	@Override
	public List<BoardDto> selectPage(Map map) {

		return sm.selectList(namespace + "selectPage", map);
	}

	@Override
	public List<BoardDto> searchSelectPage(SearchHandler sc) {
		return sm.selectList(namespace + "searchSelectPage", sc);
	}

	@Override
	public int searchCount(SearchHandler sc) {
		return sm.selectOne(namespace + "searchCount" , sc);
	}

	@Override
	public int getCount() {
		return sm.selectOne(namespace + "getCount");
	}

	@Override
	public int insert(BoardDto dto) {
		return sm.insert(namespace + "insert", dto);
	}

	@Override
	public int update(BoardDto dto) {
		return sm.update(namespace + "update", dto);
	}

	@Override
	public int updateCommentCnt(Integer comment_seq, Integer board_seq) {
		Map map = new HashMap();
		map.put("comment_seq", comment_seq);
		map.put("board_seq", board_seq);
		return sm.update(namespace + "updateCommentCnt", map);
	}

	@Override
	public int increaseViewCnt(Integer board_seq) {
		return sm.update(namespace + "increaseViewCnt" , board_seq);
	}
	
	
	@Override
	public int delete(Integer board_seq) {
		return sm.delete(namespace + "delete", board_seq);
	}

}
