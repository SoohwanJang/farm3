package com.farm.web.entity;

public class Delivery {
	private int id;
	private String comId;
	private String name;
	private String phone;
	
	public Delivery() {
		// TODO Auto-generated constructor stub
	}

	public Delivery(int id, String comId, String name, String phone) {
		super();
		this.id = id;
		this.comId = comId;
		this.name = name;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComId() {
		return comId;
	}

	public void setComId(String comId) {
		this.comId = comId;
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

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", comId=" + comId + ", name=" + name + ", phone=" + phone + "]";
	}

	
}
