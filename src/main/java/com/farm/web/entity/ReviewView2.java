package com.farm.web.entity;

import java.util.Date;

public class ReviewView2 extends Review{
	private String uid;
	private String name;
	private String image;
	private int sellerId;
	
	public ReviewView2() {
		// TODO Auto-generated constructor stub
	}

	public ReviewView2(int id, int writerId, int itemId, String title, String content, int hit, int rate, Date regDate,
			int like, String image) {
		super(id, writerId, itemId, title, content, hit, rate, regDate, like, image);
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	@Override
	public String toString() {
		return "ReviewView2 [uid=" + uid + ", name=" + name + ", image=" + image + ", sellerId=" + sellerId
				+ ", toString()=" + super.toString() + "]";
	}


	
}
