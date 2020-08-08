package com.farm.web.entity;

import java.util.Date;

public class Item {

   private int id;
   private int sellerId;
   private int categoryId;
   private int originId;
   private String name;
   private String regName;
   private String detail;
   private int price;
   private Date regDate;
   private Date startDate;
   private Date endDate;
   private int leadTime;
   private String image;
   private String tag;
   private boolean pub;
   private boolean isdel;
   private int deliveryFee;
   
   public Item() {
      // TODO Auto-generated constructor stub
   }
   
   public Item(int id, int sellerId, int categoryId, int originId, String name, String regName, String detail,
         int price, Date regDate, Date startDate, Date endDate, int leadTime, String image, String tag, boolean pub,
         boolean isdel, int deliveryFee) {
      super();
      this.id = id;
      this.sellerId = sellerId;
      this.categoryId = categoryId;
      this.originId = originId;
      this.name = name;
      this.regName = regName;
      this.detail = detail;
      this.price = price;
      this.regDate = regDate;
      this.startDate = startDate;
      this.endDate = endDate;
      this.leadTime = leadTime;
      this.image = image;
      this.tag = tag;
      this.pub = pub;
      this.isdel = isdel;
      this.deliveryFee = deliveryFee;
   }

   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }
   public int getSellerId() {
      return sellerId;
   }
   public void setSellerId(int sellerId) {
      this.sellerId = sellerId;
   }
   public int getCategoryId() {
      return categoryId;
   }
   public void setCategoryId(int categoryId) {
      this.categoryId = categoryId;
   }
   public int getOriginId() {
      return originId;
   }
   public void setOriginId(int originId) {
      this.originId = originId;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getRegName() {
      return regName;
   }
   public void setRegName(String regName) {
      this.regName = regName;
   }
   public String getDetail() {
      return detail;
   }
   public void setDetail(String detail) {
      this.detail = detail;
   }
   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   public Date getRegDate() {
      return regDate;
   }
   public void setRegDate(Date regDate) {
      this.regDate = regDate;
   }
   public Date getStartDate() {
      return startDate;
   }
   public void setStartDate(Date startDate) {
      this.startDate = startDate;
   }
   public Date getEndDate() {
      return endDate;
   }
   public void setEndDate(Date endDate) {
      this.endDate = endDate;
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
   public String getTag() {
      return tag;
   }
   public void setTag(String tag) {
      this.tag = tag;
   }
   public boolean isPub() {
      return pub;
   }
   public void setPub(boolean pub) {
      this.pub = pub;
   }
   public boolean isIsdel() {
      return isdel;
   }
   public void setIsdel(boolean isdel) {
      this.isdel = isdel;
   }
   public int getDeliveryFee() {
      return deliveryFee;
   }
   public void setDeliveryFee(int deliveryFee) {
      this.deliveryFee = deliveryFee;
   }

   @Override
   public String toString() {
      return "Item [id=" + id + ", sellerId=" + sellerId + ", categoryId=" + categoryId + ", originId=" + originId
            + ", name=" + name + ", regName=" + regName + ", detail=" + detail + ", price=" + price + ", regDate="
            + regDate + ", startDate=" + startDate + ", endDate=" + endDate + ", leadTime=" + leadTime + ", image="
            + image + ", tag=" + tag + ", pub=" + pub + ", isdel=" + isdel + ", deliveryFee=" + deliveryFee + "]";
   }
   
}