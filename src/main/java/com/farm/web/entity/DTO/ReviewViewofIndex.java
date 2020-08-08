package com.farm.web.entity.DTO;

import com.farm.web.entity.Review;

public class ReviewViewofIndex extends Review{

	
	private String uid;
	private String name;
	private String productName;
	
	
	
	
	public ReviewViewofIndex() {
		super();
	}
	public ReviewViewofIndex(String uid, String name, String productName) {
		super();
		this.uid = uid;
		this.name = name;
		this.productName = productName;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "ReviewViewofIndex [uid=" + uid + ", name=" + name + ", productName=" + productName + "]";
	}
	
	
	
}
