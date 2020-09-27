package com.farm.web.entity;

public class OrderItem {
   
   private int id; 
   private int orderId; 
   private int itemId; 
   private int qty; 
   private int deliveryId; 
   private String waybillNum;
   private String status; 
 
   
   public OrderItem() {
      // TODO Auto-generated constructor stub
   }


	public OrderItem(int id, int orderId, int itemId, int qty, int deliveryId, String waybillNum, String status) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.itemId = itemId;
		this.qty = qty;
		this.deliveryId = deliveryId;
		this.waybillNum = waybillNum;
		this.status = status;
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


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public int getDeliveryId() {
		return deliveryId;
	}


	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}


	public String getWaybillNum() {
		return waybillNum;
	}


	public void setWaybillNum(String waybillNum) {
		this.waybillNum = waybillNum;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderId=" + orderId + ", itemId=" + itemId + ", qty=" + qty + ", deliveryId="
				+ deliveryId + ", waybillNum=" + waybillNum + ", status=" + status + "]";
	}

   
}