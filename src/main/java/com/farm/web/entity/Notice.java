package com.farm.web.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Notice {

	private int id;
	private int writerId;
	private String title;
	private String content;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date regDate;
	private int hit;
	private boolean pub;

	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(int id, int writerId, String title, String content, Date regDate, int hit, boolean pub) {
		super();
		this.id = id;
		this.writerId = writerId;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
		this.pub = pub;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public boolean getPub() {
		return pub;
	}

	public void setPub(boolean pub) {
		this.pub = pub;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", writerId=" + writerId + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + ", hit=" + hit + ", pub=" + pub + "]";
	}
	
	
}
