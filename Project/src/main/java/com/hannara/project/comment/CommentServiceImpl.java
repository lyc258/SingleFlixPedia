package com.hannara.project.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hannara.project.board.BoardDao;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	BoardDao boardDao;
	@Autowired
	CommentDao commentDao;

	@Override
	public int getCount(Integer board_seq) throws Exception {
		return commentDao.getCount(board_seq);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int delete(Integer comment_seq, Integer board_seq, String writer) throws Exception {

		int rowCnt = boardDao.updateCommentCnt(board_seq, -1);
		System.out.println("updateCommentCnt - rowCnt = " + rowCnt);
		rowCnt = commentDao.delete(comment_seq, writer);
		System.out.println("rowCnt = " + rowCnt);

		return rowCnt;

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insert(CommentDto commentDto) throws Exception {
		boardDao.updateCommentCnt(commentDto.getBoard_seq(), 1); // +1
		return commentDao.insert(commentDto);

	}

	@Override
	public int update(CommentDto commentDto) throws Exception {
		return commentDao.update(commentDto);
	}

	@Override
	public CommentDto select(Integer comment_seq) throws Exception {
		return commentDao.select(comment_seq);
	}

	@Override
	public List<CommentDto> selectList(Integer board_seq) throws Exception {
		return commentDao.selectList(board_seq);
	}

}