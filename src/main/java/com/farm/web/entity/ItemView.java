package com.farm.web.entity;

public class ItemView extends Item{
	private String sellDate;
	private String catgName;
	private String catgPName;
	private String sellerUid;
	private String sellerName;
	
	public String getSellDate() {
		return sellDate;
	}
	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}
	public String getCatgName() {
		return catgName;
	}
	public void setCatgName(String catgName) {
		this.catgName = catgName;
	}
	public String getCatgPName() {
		return catgPName;
	}
	public void setCatgPName(String catgPName) {
		this.catgPName = catgPName;
	}
	public String getSellerUid() {
		return sellerUid;
	}
	public void setSellerUid(String sellerUid) {
		this.sellerUid = sellerUid;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	@Override
	public String toString() {
		return "ItemView [sellDate=" + sellDate + ", catgName=" + catgName + ", catgPName=" + catgPName + ", sellerUid="
				+ sellerUid + ", sellerName=" + sellerName + ", toString()=" + super.toString() + "]";
	}
	
	
}
