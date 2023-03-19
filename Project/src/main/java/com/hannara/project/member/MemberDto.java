package com.hannara.project.member;

import java.util.Date;

public class MemberDto {

	private String member_id;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private String address1;
	private String address2;
	private String sns;
	private Date regdate;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getSns() {
		return sns;
	}
	public void setSns(String sns) {
		this.sns = sns;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "MemberDto [member_id=" + member_id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone + ", email="
				+ email + ", address1=" + address1 + ", address2=" + address2 + ", sns=" + sns + ", regdate=" + regdate
				+ "]";
	}
	
	
}
