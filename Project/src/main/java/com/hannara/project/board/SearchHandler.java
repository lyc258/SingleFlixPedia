package com.hannara.project.board;

import org.springframework.web.util.UriComponentsBuilder;

import static java.lang.Math.*;
import static java.util.Objects.requireNonNullElse;

public class SearchHandler {
	private Integer page = 1;
	private Integer pageSize = 10;
	//private Integer offset = 0;
	private String option = "";
	private String keyword = "";

	public SearchHandler() {
	}

	public SearchHandler(Integer page, Integer pageSize) {
		this(page, pageSize, "", "");
	}

	public SearchHandler(Integer page, Integer pageSize, String option, String keyword) {
		this.page = page;
		this.pageSize = pageSize;
		this.option = option;
		this.keyword = keyword;
	}

	public String getQueryString() {
		return getQueryString(page);
	}

	public String getQueryString(Integer page) {
		// ?page=10&pageSize=10&option=A&keyword=title
		return UriComponentsBuilder.newInstance().queryParam("page", page).queryParam("pageSize", pageSize)
				.queryParam("option", option).queryParam("keyword", keyword).build().toString();
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getOffset() {
		return (page-1) * pageSize;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "SearchHandler [page=" + page + ", pageSize=" + pageSize + ", offset=" + getOffset() + ", option=" + option
				+ ", keyword=" + keyword + "]";
	}

	

	
}