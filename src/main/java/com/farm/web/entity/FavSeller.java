package com.farm.web.entity;

import java.util.Date;

public class FavSeller {

	private int id;
	private int memberId;
	private int sellerId;
	private Date regDate;
	
	public FavSeller() {
		// TODO Auto-generated constructor stub
	}

	public FavSeller(int id, int memberId, int sellerId, Date regDate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.sellerId = sellerId;
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "FavSeller [id=" + id + ", memberId=" + memberId + ", sellerId=" + sellerId + ", regDate=" + regDate
				+ "]";
	}
	
	
}
