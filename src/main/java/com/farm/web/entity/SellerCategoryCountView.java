package com.farm.web.entity;

public class SellerCategoryCountView {
	private int id;
	private String name;
	private int count;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public SellerCategoryCountView(int id, String name, int count) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
	}
	@Override
	public String toString() {
		return "SellerCountView [id=" + id + ", name=" + name + ", count=" + count + "]";
	}
	
	
}
