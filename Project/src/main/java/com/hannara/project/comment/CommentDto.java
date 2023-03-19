package com.hannara.project.comment;

import java.util.Date;

public class CommentDto {
	private int comment_seq;
	private int board_seq;
	private int pcomment_seq;
	private String comment;
	private String writer;
	private Date regdate;

	public CommentDto() {
	}

	public CommentDto(int board_seq, int pcomment_seq, String comment, String writer) {
		super();
		this.board_seq = board_seq;
		this.pcomment_seq = pcomment_seq;
		this.comment = comment;
		this.writer = writer;
	}

	public int getComment_seq() {
		return comment_seq;
	}

	public void setComment_seq(int comment_seq) {
		this.comment_seq = comment_seq;
	}

	public int getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}

	public int getPcomment_seq() {
		return pcomment_seq;
	}

	public void setPcomment_seq(int pcomment_seq) {
		this.pcomment_seq = pcomment_seq;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "CommentDto [comment_seq=" + comment_seq + ", board_seq=" + board_seq + ", pcomment_seq=" + pcomment_seq
				+ ", comment=" + comment + ", writer=" + writer + ", regdate=" + regdate + "]";
	}

}
