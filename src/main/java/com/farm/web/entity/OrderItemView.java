package com.farm.web.entity;

import java.util.Date;

public class OrderItemView{

	private int id;
	private int orderId;
	private int itemId;
	private int deliveryId;
	private int qty;
	private int oiStatus;
	private int waybillNum;
	private String mUid;
	private String mName;
	private String iName;
	private String iRegName;
	private String iImage;
	private int iSellerId;
	private int iPrice;
	private Date oRegDate;
	private String oDes;
	private Date oDueDate;
	private Date oCfDate;
	private String oMemo;
	private String oPayMethod;
	private int oStatus;
	private String dComId;
	private String dName;
	
	
	public OrderItemView() {
		// TODO Auto-generated constructor stub
	}


	public OrderItemView(int id, int orderId, int itemId, int deliveryId, int qty, int oiStatus, int waybillNum,
			String mUid, String mName, String iName, String iRegName, String iImage, int iSellerId, int iPrice,
			Date oRegDate, String oDes, Date oDueDate, Date oCfDate, String oMemo, String oPayMethod, int oStatus,
			String dComId, String dName) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.itemId = itemId;
		this.deliveryId = deliveryId;
		this.qty = qty;
		this.oiStatus = oiStatus;
		this.waybillNum = waybillNum;
		this.mUid = mUid;
		this.mName = mName;
		this.iName = iName;
		this.iRegName = iRegName;
		this.iImage = iImage;
		this.iSellerId = iSellerId;
		this.iPrice = iPrice;
		this.oRegDate = oRegDate;
		this.oDes = oDes;
		this.oDueDate = oDueDate;
		this.oCfDate = oCfDate;
		this.oMemo = oMemo;
		this.oPayMethod = oPayMethod;
		this.oStatus = oStatus;
		this.dComId = dComId;
		this.dName = dName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public int getDeliveryId() {
		return deliveryId;
	}


	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public int getOiStatus() {
		return oiStatus;
	}


	public void setOiStatus(int oiStatus) {
		this.oiStatus = oiStatus;
	}


	public int getWaybillNum() {
		return waybillNum;
	}


	public void setWaybillNum(int waybillNum) {
		this.waybillNum = waybillNum;
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


	public Date getoDueDate() {
		return oDueDate;
	}


	public void setoDueDate(Date oDueDate) {
		this.oDueDate = oDueDate;
	}


	public Date getoCfDate() {
		return oCfDate;
	}


	public void setoCfDate(Date oCfDate) {
		this.oCfDate = oCfDate;
	}


	public String getoMemo() {
		return oMemo;
	}


	public void setoMemo(String oMemo) {
		this.oMemo = oMemo;
	}


	public String getoPayMethod() {
		return oPayMethod;
	}


	public void setoPayMethod(String oPayMethod) {
		this.oPayMethod = oPayMethod;
	}


	public int getoStatus() {
		return oStatus;
	}


	public void setoStatus(int oStatus) {
		this.oStatus = oStatus;
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
		return "OrderItemView [id=" + id + ", orderId=" + orderId + ", itemId=" + itemId + ", deliveryId=" + deliveryId
				+ ", qty=" + qty + ", oiStatus=" + oiStatus + ", waybillNum=" + waybillNum + ", mUid=" + mUid
				+ ", mName=" + mName + ", iName=" + iName + ", iRegName=" + iRegName + ", iImage=" + iImage
				+ ", iSellerId=" + iSellerId + ", iPrice=" + iPrice + ", oRegDate=" + oRegDate + ", oDes=" + oDes
				+ ", oDueDate=" + oDueDate + ", oCfDate=" + oCfDate + ", oMemo=" + oMemo + ", oPayMethod=" + oPayMethod
				+ ", oStatus=" + oStatus + ", dComId=" + dComId + ", dName=" + dName + "]";
	}

	
	

	
}
