package com.hannara.project.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl implements CommentDao {

	@Autowired
	SqlSessionTemplate sm;
	private static String namespace = "Comment.";

	@Override
	public int getCount(Integer board_seq) {
		return sm.selectOne(namespace + "getCount", board_seq);
	}

	@Override
	public int deleteAll(Integer board_seq) {
		return sm.delete(namespace + "deleteAll", board_seq);
	}

	@Override
	public int delete(Integer comment_seq, String writer) {
		Map map = new HashMap();
		map.put("comment_seq", comment_seq);
		map.put("writer", writer);

		return sm.delete(namespace + "delete", map);
	}

	@Override
	public int insert(CommentDto commentDto) {
		return sm.insert(namespace  + "insert", commentDto);
	}

	@Override
	public int update(CommentDto commentDto) {
		return sm.update(namespace + "update",commentDto);
	}

	@Override
	public List<CommentDto> selectList(Integer board_seq) {
		return sm.selectList(namespace + "selectList", board_seq);
	}

	@Override
	public CommentDto select(Integer comment_seq) {
		return sm.selectOne(namespace + "select", comment_seq);
	}

}
