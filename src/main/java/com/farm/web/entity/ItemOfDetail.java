package com.farm.web.entity;

public class ItemOfDetail extends Item{
	
	private String category;
	private String subCategory;
	private String origin;
	private String subOrigin;
	
	
	
	public ItemOfDetail() {
		
	}
	
	public ItemOfDetail(String category, String subCategory, String origin, String subOrigin) {
		super();
		this.category = category;
		this.subCategory = subCategory;
		this.origin = origin;
		this.subOrigin = subOrigin;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getSubOrigin() {
		return subOrigin;
	}
	public void setSubOrigin(String subOrigin) {
		this.subOrigin = subOrigin;
	}

	@Override
	public String toString() {
		return "ItemOfDetailView [category=" + category + ", subCategory=" + subCategory + ", origin=" + origin
				+ ", subOrigin=" + subOrigin + "]";
	}
	
	
	
	
}
