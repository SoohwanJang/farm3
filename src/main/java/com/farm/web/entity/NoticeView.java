package com.farm.web.entity;

import java.util.Date;

public class NoticeView extends Notice {
	private String uid;
	private String name;
	
	public NoticeView() {
		// TODO Auto-generated constructor stub
	}

	public NoticeView(int id, int writerId, String title, String content, Date regDate, int hit, boolean pub) {
		super(id, writerId, title, content, regDate, hit, pub);
		// TODO Auto-generated constructor stub
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	
}
