package com.farm.web.entity;

import java.util.Date;

public class Order {
	private int id; 
	private int memberId; 
	private String destination; 
	private Date regDate;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int id, int memberId, String destination, Date regDate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.destination = destination;
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

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", memberId=" + memberId + ", destination=" + destination + ", regDate=" + regDate
				+ "]";
	}
	
}
