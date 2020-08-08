package com.farm.web.entity;

import java.util.Date;

public class Basket {

	private int id;
	private int itemId;
	private int memberId;
	private int qty;
	private Date regDate;
	

	public Basket() {
		// TODO Auto-generated constructor stub
	}
	
	public Basket(int id, int itemId, int memberId, int qty, Date regDate) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.memberId = memberId;
		this.qty = qty;
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Basket [id=" + id + ", itemId=" + itemId + ", memberId=" + memberId + ", qty=" + qty + ", regDate="
				+ regDate + "]";
	}
	
}
