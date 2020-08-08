package com.farm.web.entity;

import java.util.Date;

public class FavItem {
	
	private int id;
	private int itemId;
	private int memberId;
	private Date regDate;
	
	public FavItem() {
		// TODO Auto-generated constructor stub
	}

	public FavItem(int id, int itemId, int memberId, Date regDate) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.memberId = memberId;
		this.regDate = regDate;
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

	@Override
	public String toString() {
		return "FavItem [id=" + id + ", itemId=" + itemId + ", memberId=" + memberId + ", regDate=" + regDate + "]";
	}
	
	
}
