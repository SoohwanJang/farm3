package com.farm.web.entity;

import java.util.Date;

public class OrderItemView extends OrderItem{

	private String mUid;
	private String mName;
	private String iName;
	private String iRegName;
	private String iImage;
	private int iSellerId;
	private int iPrice;
	private Date oRegDate;
	private String oDes;
	private String dComId;
	private String dName;
	
	public OrderItemView() {
		// TODO Auto-generated constructor stub
	}

	public String getmUid() {
		return mUid;
	}

	public void setmUid(String mUid) {
		this.mUid = mUid;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getiRegName() {
		return iRegName;
	}

	public void setiRegName(String iRegName) {
		this.iRegName = iRegName;
	}

	public String getiImage() {
		return iImage;
	}

	public void setiImage(String iImage) {
		this.iImage = iImage;
	}

	public int getiSellerId() {
		return iSellerId;
	}

	public void setiSellerId(int iSellerId) {
		this.iSellerId = iSellerId;
	}

	public int getiPrice() {
		return iPrice;
	}

	public void setiPrice(int iPrice) {
		this.iPrice = iPrice;
	}

	public Date getoRegDate() {
		return oRegDate;
	}

	public void setoRegDate(Date oRegDate) {
		this.oRegDate = oRegDate;
	}

	public String getoDes() {
		return oDes;
	}

	public void setoDes(String oDes) {
		this.oDes = oDes;
	}

	public String getdComId() {
		return dComId;
	}

	public void setdComId(String dComId) {
		this.dComId = dComId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	@Override
	public String toString() {
		return "OrderItemView [mUid=" + mUid + ", mName=" + mName + ", iName=" + iName + ", iRegName=" + iRegName
				+ ", iImage=" + iImage + ", iSellerId=" + iSellerId + ", iPrice=" + iPrice + ", oRegDate=" + oRegDate
				+ ", oDes=" + oDes + ", dComId=" + dComId + ", dName=" + dName + ", toString()=" + super.toString()
				+ "]";
	}
	
}
