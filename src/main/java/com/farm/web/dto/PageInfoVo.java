package com.farm.web.dto;

public class PageInfoVo {

	private int lastPage;
	private int pageOffset;
	
	public PageInfoVo() {
		// TODO Auto-generated constructor stub
	}
	
	public PageInfoVo(int lastPage, int pageOffset) {
		super();
		this.lastPage = lastPage;
		this.pageOffset = pageOffset;
	}

	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getPageOffset() {
		return pageOffset;
	}
	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}
	@Override
	public String toString() {
		return "PageInfoVo [lastPage=" + lastPage + ", pageOffset=" + pageOffset + "]";
	}
	
	
}
