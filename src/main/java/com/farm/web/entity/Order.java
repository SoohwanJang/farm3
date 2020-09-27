package com.farm.web.entity;

import java.util.Date;

public class Order {
	private int id; 
	private int memberId; 
	private String destination; 
	private Date regDate;
	private String payMethod;
	private Date dueDate;
	private Date cfDate;
	private String memo;
	private int status;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int id, int memberId, String destination, Date regDate, String payMethod, Date dueDate, Date cfDate,
			String memo, int status) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.destination = destination;
		this.regDate = regDate;
		this.payMethod = payMethod;
		this.dueDate = dueDate;
		this.cfDate = cfDate;
		this.memo = memo;
		this.status = status;
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

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCfDate() {
		return cfDate;
	}

	public void setCfDate(Date cfDate) {
		this.cfDate = cfDate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", memberId=" + memberId + ", destination=" + destination + ", regDate=" + regDate
				+ ", payMethod=" + payMethod + ", dueDate=" + dueDate + ", cfDate=" + cfDate + ", memo=" + memo
				+ ", status=" + status + "]";
	}


}
