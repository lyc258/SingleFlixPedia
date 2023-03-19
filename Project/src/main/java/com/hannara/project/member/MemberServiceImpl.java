package com.hannara.project.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao dao;

	@Override
	public int join(MemberDto dto) {
		return dao.join(dto);

	}

	@Override
	public MemberDto getinfo(String member_id) {
		return dao.getinfo(member_id);
	}
}
