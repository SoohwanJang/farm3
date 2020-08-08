package com.farm.web.entity;

import java.util.Date;

public class OrderItem {
   
   private int id; 
   private int orderId; 
   private int itemId; 
   private int deliveryId; 
   private int qty; 
   private String payMethod; 
   private String status; 
   private String deliveryMemo; 
   private String waybillNum;
   private Date payDDate; 
   private Date payCDate;
   
   public OrderItem() {
      // TODO Auto-generated constructor stub
   }

   public OrderItem(int id, int orderId, int itemId, int deliveryId, int qty, String payMethod, String status,
         String deliveryMemo, String waybillNum, Date payDDate, Date payCDate) {
      super();
      this.id = id;
      this.orderId = orderId;
      this.itemId = itemId;
      this.deliveryId = deliveryId;
      this.qty = qty;
      this.payMethod = payMethod;
      this.status = status;
      this.deliveryMemo = deliveryMemo;
      this.waybillNum = waybillNum;
      this.payDDate = payDDate;
      this.payCDate = payCDate;
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

   public String getPayMethod() {
      return payMethod;
   }

   public void setPayMethod(String payMethod) {
      this.payMethod = payMethod;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getDeliveryMemo() {
      return deliveryMemo;
   }

   public void setDeliveryMemo(String deliveryMemo) {
      this.deliveryMemo = deliveryMemo;
   }

   public String getWaybillNum() {
      return waybillNum;
   }

   public void setWaybillNum(String waybillNum) {
      this.waybillNum = waybillNum;
   }

   public Date getPayDDate() {
      return payDDate;
   }

   public void setPayDDate(Date payDDate) {
      this.payDDate = payDDate;
   }

   public Date getPayCDate() {
      return payCDate;
   }

   public void setPayCDate(Date payCDate) {
      this.payCDate = payCDate;
   }

   @Override
   public String toString() {
      return "OrderItem [id=" + id + ", orderId=" + orderId + ", itemId=" + itemId + ", deliveryId=" + deliveryId
            + ", qty=" + qty + ", payMethod=" + payMethod + ", status=" + status + ", deliveryMemo=" + deliveryMemo
            + ", waybillNum=" + waybillNum + ", payDDate=" + payDDate + ", payCDate=" + payCDate + "]";
   }

   
}