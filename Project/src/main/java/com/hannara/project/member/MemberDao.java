package com.hannara.project.member;

public interface MemberDao {
	
	public int join(MemberDto dto);
	
	public MemberDto getinfo(String member_id);
	

}
