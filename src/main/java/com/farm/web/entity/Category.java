package com.farm.web.entity;

public class Category {

	private int id;
	private String name;
	private int sup;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name, int sup) {
		super();
		this.id = id;
		this.name = name;
		this.sup = sup;
	}

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

	public int getSup() {
		return sup;
	}

	public void setSup(int sup) {
		this.sup = sup;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", sup=" + sup + "]";
	}
	
	

}
