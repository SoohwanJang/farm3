package com.farm.web.entity;

import java.util.Date;

public class CustQnA {

	private int id;
	private int writerId;
	private String title;
	private String content;
	private Date regDate;
	private String contentA;
	private Date regDateA;
	
	public CustQnA() {
		// TODO Auto-generated constructor stub
	}

	public CustQnA(int id, int writerId, String title, String content, Date regDate, String contentA, Date regDateA) {
		super();
		this.id = id;
		this.writerId = writerId;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.contentA = contentA;
		this.regDateA = regDateA;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getContentA() {
		return contentA;
	}

	public void setContentA(String contentA) {
		this.contentA = contentA;
	}

	public Date getRegDateA() {
		return regDateA;
	}

	public void setRegDateA(Date regDateA) {
		this.regDateA = regDateA;
	}

	@Override
	public String toString() {
		return "CustQnA [id=" + id + ", writerId=" + writerId + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + ", contentA=" + contentA + ", regDateA=" + regDateA + "]";
	}
	
	
}
