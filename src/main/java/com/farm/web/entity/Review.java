package com.farm.web.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Review {
	private int id; 
	private int writerId;
	private int itemId; 
	private String title; 
	private String content; 
	private int hit;
	private int rate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date regDate; 
	private int like;
	private String image;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int id, int writerId, int itemId, String title, String content, int hit, int rate, Date regDate,
			int like, String image) {
		super();
		this.id = id;
		this.writerId = writerId;
		this.itemId = itemId;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.rate = rate;
		this.regDate = regDate;
		this.like = like;
		this.image = image;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", writerId=" + writerId + ", itemId=" + itemId + ", title=" + title + ", content="
				+ content + ", hit=" + hit + ", rate=" + rate + ", regDate=" + regDate + ", like=" + like + ", image="
				+ image + "]";
	}
	
	
	
}
