package com.farm.web.entity;

import java.util.Date;

public class FavItemView{
	
	private int id;
	private int itemId;
	private int memberId;
	private Date regDate;
	private String itemName;
	private String itemImgName;
	
	public FavItemView() {
		// TODO Auto-generated constructor stub
	}

	public FavItemView(int id, int itemId, int memberId, Date regDate, String itemName, String itemImgName) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.memberId = memberId;
		this.regDate = regDate;
		this.itemName = itemName;
		this.itemImgName = itemImgName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemImgName() {
		return itemImgName;
	}

	public void setItemImgName(String itemImgName) {
		this.itemImgName = itemImgName;
	}

	@Override
	public String toString() {
		return "FavItemView [id=" + id + ", itemId=" + itemId + ", memberId=" + memberId + ", regDate=" + regDate
				+ ", itemName=" + itemName + ", itemImgName=" + itemImgName + "]";
	}
	
}
