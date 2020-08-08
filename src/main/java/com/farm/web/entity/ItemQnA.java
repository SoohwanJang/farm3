package com.farm.web.entity;

import java.util.Date;

public class ItemQnA {
	
	private int id;
	private int writerId;
	private int itemId;
	private String title;
	private String content;
	private Date regDate;
	private String image;
	private String contentA;
	private Date regDateA;
	private int hit;
	
	public ItemQnA() {
		// TODO Auto-generated constructor stub
	}

	public ItemQnA(int id, int writerId, int itemId, String title, String content, Date regDate, String image,
			String contentA, Date regDateA, int hit) {
		super();
		this.id = id;
		this.writerId = writerId;
		this.itemId = itemId;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.image = image;
		this.contentA = contentA;
		this.regDateA = regDateA;
		this.hit = hit;
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

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "ItemQnA [id=" + id + ", writerId=" + writerId + ", itemId=" + itemId + ", title=" + title + ", content="
				+ content + ", regDate=" + regDate + ", image=" + image + ", contentA=" + contentA + ", regDateA="
				+ regDateA + ", hit=" + hit + "]";
	}

	
	
}
