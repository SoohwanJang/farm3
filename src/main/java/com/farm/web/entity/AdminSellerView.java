package com.farm.web.entity;

import java.util.Date;

public class AdminSellerView {

	private String address;
	private String comName;
	private String email;
	private int id;
	private String mobile;
	private String name;
	private String phone;
	private Date regDate;
	private String uid;

	public AdminSellerView() {
		// TODO Auto-generated constructor stub
	}

	public AdminSellerView(String address, String comName, String email, int id, String mobile, String name, String phone,
			Date regDate, String uid) {
		super();
		this.address = address;
		this.comName = comName;
		this.email = email;
		this.id = id;
		this.mobile = mobile;
		this.name = name;
		this.phone = phone;
		this.regDate = regDate;
		this.uid = uid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "AdminSellerView [address=" + address + ", comName=" + comName + ", email=" + email + ", id=" + id
				+ ", mobile=" + mobile + ", name=" + name + ", phone=" + phone + ", regDate=" + regDate + ", uid=" + uid
				+ "]";
	}

}
