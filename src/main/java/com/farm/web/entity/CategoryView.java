package com.farm.web.entity;

public class CategoryView extends Category{
	private String pName;
	
	public CategoryView() {
	}

	public CategoryView(int id, String name, int sup, String pName) {
		super(id, name, sup);
		this.pName = pName;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	@Override
	public String toString() {
		return "CategoryView [pName=" + pName + ", toString()=" + super.toString() + "]";
	}
	
}
