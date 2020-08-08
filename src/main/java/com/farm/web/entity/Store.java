package com.farm.web.entity;

import java.util.Date;

public class Store {
	private int itemId;
	private int qty;
	private Date regDate;
	
	public Store() {
		// TODO Auto-generated constructor stub
	}

	public Store(int itemId, int qty, Date regDate) {
		super();
		this.itemId = itemId;
		this.qty = qty;
		this.regDate = regDate;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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
		return "Store [itemId=" + itemId + ", qty=" + qty + ", regDate=" + regDate + "]";
	}
	
	
}
