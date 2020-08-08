package com.farm.web.entity;

import java.util.Date;

public class BasketPayView extends Basket{
	private String itemName;
	private int price;
	private int leadTime;
	private String image;
	private int deliveryFee;
	private String ordererName;
	private String ordererEmail;
	private String ordererAddress;
	private String ordererMobile;
	private String sellerName;
	private String sellerComName;
	
	public BasketPayView() {}

	public BasketPayView(int id, int itemId, int memberId, int qty, Date regDate, String itemName, int price, int leadTime, String image, int deliveryFee, String ordererName,
			String ordererEmail, String ordererAddress, String ordererMobile, String sellerName, String sellerComName) {
		super(id, itemId, memberId, qty, regDate);
		this.itemName = itemName;
		this.price = price;
		this.leadTime = leadTime;
		this.image = image;
		this.deliveryFee = deliveryFee;
		this.ordererName = ordererName;
		this.ordererEmail = ordererEmail;
		this.ordererAddress = ordererAddress;
		this.ordererMobile = ordererMobile;
		this.sellerName = sellerName;
		this.sellerComName = sellerComName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public int getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(int deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public String getOrdererName() {
		return ordererName;
	}

	public void setOrdererName(String ordererName) {
		this.ordererName = ordererName;
	}

	public String getOrdererEmail() {
		return ordererEmail;
	}

	public void setOrdererEmail(String ordererEmail) {
		this.ordererEmail = ordererEmail;
	}

	public String getOrdererAddress() {
		return ordererAddress;
	}

	public void setOrdererAddress(String ordererAddress) {
		this.ordererAddress = ordererAddress;
	}

	public String getOrdererMobile() {
		return ordererMobile;
	}

	public void setOrdererMobile(String ordererMobile) {
		this.ordererMobile = ordererMobile;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerComName() {
		return sellerComName;
	}

	public void setSellerComName(String sellerComName) {
		this.sellerComName = sellerComName;
	}

	@Override
	public String toString() {
		return "BasketPayView [itemName=" + itemName + ", price=" + price + ", leadTime=" + leadTime + ", image="
				+ image + ", deliveryFee=" + deliveryFee + ", ordererName=" + ordererName + ", ordererEmail="
				+ ordererEmail + ", ordererAddress=" + ordererAddress + ", ordererMobile=" + ordererMobile
				+ ", sellerName=" + sellerName + ", sellerComName=" + sellerComName + ", toString()=" + super.toString()
				+ "]";
	}
	
}
