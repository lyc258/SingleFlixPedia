package com.hannara.project.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSessionTemplate sm;
	private static String namespace = "Member.";
	
	@Override
	public int join(MemberDto dto) {
		return sm.insert(namespace + "join", dto);
	}
	
	@Override
	public MemberDto getinfo(String member_id) {
		return sm.selectOne(namespace + "getinfo", member_id);
	}
	

}
