package com.farm.web.entity;

import java.util.Date;

public class SellerItemView {

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
	private String firstcatg;
	private String secondcatg;
	private String firstorigin;
	private String secondorigin; 
	private int qty;
	private boolean isDel;
	private String uid; 
	
	public SellerItemView() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public SellerItemView(int id, int sellerId, int categoryId, int originId, String name, String regName,
			String detail, int price, Date regDate, Date startDate, Date endDate, int leadTime, String image,
			String tag, boolean pub, String firstcatg, String secondcatg, String firstorigin, String secondorigin,
			int qty, boolean isDel, String uid) {
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
		this.firstcatg = firstcatg;
		this.secondcatg = secondcatg;
		this.firstorigin = firstorigin;
		this.secondorigin = secondorigin;
		this.qty = qty;
		this.isDel = isDel;
		this.uid = uid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
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

	public boolean getPub() {
		return pub;
	}

	public void setPub(boolean pub) {
		this.pub = pub;
	}

	public String getFirstcatg() {
		return firstcatg;
	}

	public void setFirstcatg(String firstcatg) {
		this.firstcatg = firstcatg;
	}

	public String getSecondcatg() {
		return secondcatg;
	}

	public void setSecondcatg(String secondcatg) {
		this.secondcatg = secondcatg;
	}

	public String getFirstorigin() {
		return firstorigin;
	}

	public void setFirstorigin(String firstorigin) {
		this.firstorigin = firstorigin;
	}

	public String getSecondorigin() {
		return secondorigin;
	}

	public void setSecondorigin(String secondorigin) {
		this.secondorigin = secondorigin;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public boolean isDel() {
		return isDel;
	}

	public void setDel(boolean isDel) {
		this.isDel = isDel;
	}

	@Override
	public String toString() {
		return "SellerProductView [id=" + id + ", sellerId=" + sellerId + ", categoryId=" + categoryId + ", originId="
				+ originId + ", name=" + name + ", regName=" + regName + ", detail=" + detail + ", price=" + price
				+ ", regDate=" + regDate + ", startDate=" + startDate + ", endDate=" + endDate + ", leadTime="
				+ leadTime + ", image=" + image + ", tag=" + tag + ", pub=" + pub + ", firstcatg=" + firstcatg
				+ ", secondcatg=" + secondcatg + ", firstorigin=" + firstorigin + ", secondorigin=" + secondorigin
				+ ", qty=" + qty + ", isDel=" + isDel + ", uid=" + uid + "]";
	}

}
