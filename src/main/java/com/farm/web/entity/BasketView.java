package com.farm.web.entity;

import java.util.Date;

public class BasketView extends Basket{
	private String itemName;
	private String itemDetail;
	private int price;
	private int leadTime;
	private String image;
	private Date endDate;
	private int deliveryFee;
	
	public BasketView() {}

	public BasketView(int id, int itemId, int memberId, int qty, Date regDate,
			String itemName, String itemDetail, int price, int leadTime, String image, Date endDate,
			int deliveryFee) {
		
		super(id, itemId, memberId, qty, regDate);
		this.itemName = itemName;
		this.itemDetail = itemDetail;
		this.price = price;
		this.leadTime = leadTime;
		this.image = image;
		this.endDate = endDate;
		this.deliveryFee = deliveryFee;
	}

	public String getitemName() {
		return itemName;
	}

	public void setitemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(int leadTime) {
		this.leadTime = leadTime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(int deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	@Override
	public String toString() {
		return "BasketView [itemName=" + itemName + ", itemDetail=" + itemDetail + ", price=" + price + ", leadTime="
				+ leadTime + ", image=" + image + ", endDate=" + endDate + ", deliveryFee=" + deliveryFee
				+ ", toString()=" + super.toString() + "]";
	}

	
}
