package com.hannara.project.member;

public interface MemberService {

	public int join(MemberDto dto);
	
	public MemberDto getinfo(String member_id);
}
