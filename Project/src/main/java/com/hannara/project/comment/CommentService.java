package com.hannara.project.comment;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface CommentService {

	public int getCount(Integer board_seq) throws Exception;

	@Transactional
	public int delete(Integer comment_seq, Integer board_seq, String writer) throws Exception;

	@Transactional
	public int insert(CommentDto commentDto) throws Exception;

	public int update(CommentDto commentDto) throws Exception;

	public CommentDto select(Integer comment_seq) throws Exception;

	public List<CommentDto> selectList(Integer board_seq) throws Exception;

}
