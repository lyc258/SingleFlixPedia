package com.hannara.project.board;

import org.springframework.web.util.*;

public class PageHandler {
	private SearchHandler sc;
//    private int pageSize = 10; // 한 페이지당 게시물 갯수
//    private int page; // 현재 페이지
//    private String  option;
//    private String  keyword;
	public final int NAV_SIZE = 10; // page navigation size
	private int totalCnt; // 게시물의 총 갯수
	private int totalPage; // 전체 페이지의 갯수
	private int beginPage; // 화면에 보여줄 첫 페이지
	private int endPage; // 화면에 보여줄 마지막 페이지
	private boolean showNext; // 이후를 보여줄지의 여부. endPage==totalPage이면, showNext는 false
	private boolean showPrev; // 이전을 보여줄지의 여부. beginPage==1이 아니면 showPrev는 false

	public PageHandler(int totalCnt, SearchHandler sc) {
		this.totalCnt = totalCnt;
		this.sc = sc;

		doPaging(totalCnt, sc);
	}

	private void doPaging(int totalCnt, SearchHandler sc) {
		this.totalCnt = totalCnt;

		totalPage = totalCnt / sc.getPageSize() + (totalCnt % sc.getPageSize() == 0 ? 0 : 1);
		beginPage = (sc.getPage() - 1) / NAV_SIZE * NAV_SIZE + 1;
		endPage = Math.min(beginPage + NAV_SIZE - 1, totalPage);
		showPrev = beginPage != 1;
		showNext = endPage != totalPage;
	}

	void print() {
		System.out.println("page=" + sc.getPage());
		System.out.print(showPrev ? "PREV " : "");

		for (int i = beginPage; i <= endPage; i++) {
			System.out.print(i + " ");
		}
		System.out.println(showNext ? " NEXT" : "");
	}

	public SearchHandler getSc() {
		return sc;
	}

	public void setSc(SearchHandler sc) {
		this.sc = sc;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public boolean isShowNext() {
		return showNext;
	}

	public void setShowNext(boolean showNext) {
		this.showNext = showNext;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getNAV_SIZE() {
		return NAV_SIZE;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isShowPrev() {
		return showPrev;
	}

	public void setShowPrev(boolean showPrev) {
		this.showPrev = showPrev;
	}

	@Override
	public String toString() {
		return "PageHandler{" + "sc=" + sc + ", totalCnt=" + totalCnt + ", showNext=" + showNext + ", beginPage="
				+ beginPage + ", NAV_SIZE=" + NAV_SIZE + ", totalPage=" + totalPage + ", endPage=" + endPage
				+ ", showPrev=" + showPrev + '}';
	}
}