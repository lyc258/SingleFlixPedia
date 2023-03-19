package com.hannara.project.comment;

import java.util.List;

public interface CommentDao {

	public int getCount(Integer board_seq) throws Exception;

	public int deleteAll(Integer board_seq) throws Exception;
	
	public int delete(Integer comment_seq, String writer) throws Exception;

	public int insert(CommentDto commentDto) throws Exception;

	public int update(CommentDto commentDto) throws Exception;

	public List<CommentDto> selectList(Integer board_seq) throws Exception;

	public CommentDto select(Integer comment_seq) throws Exception;

}
