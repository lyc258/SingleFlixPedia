package com.hannara.project.board;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardDto {
	private int board_seq;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int hit;
	private int comment_hit;
	private String fileName;
	private MultipartFile uploadFile;

	public int getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getComment_hit() {
		return comment_hit;
	}

	public void setComment_hit(int comment_hit) {
		this.comment_hit = comment_hit;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	@Override
	public String toString() {
		return "BoardDto [board_seq=" + board_seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regdate=" + regdate + ", hit=" + hit + ", comment_hit=" + comment_hit + ", fileName=" + fileName
				+ ", uploadFile=" + uploadFile + "]";
	}

}
