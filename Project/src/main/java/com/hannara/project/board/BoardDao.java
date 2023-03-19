package com.hannara.project.board;

import java.util.List;
import java.util.Map;

public interface BoardDao {

	public BoardDto select(Integer board_seq);

	public List<BoardDto> selectList(BoardDto dto);

	public List<BoardDto> selectPage(Map map);
	
	public List<BoardDto> searchSelectPage(SearchHandler sc);
	
	public int searchCount(SearchHandler sc);

	public int getCount();

	public int insert(BoardDto dto);

	public int update(BoardDto dto);

	public int updateCommentCnt(Integer board_seq , Integer comment_seq);
	
	public int increaseViewCnt(Integer board_seq);

	public int delete(Integer board_seq);

}
