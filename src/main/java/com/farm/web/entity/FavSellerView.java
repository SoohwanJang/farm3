package com.farm.web.entity;

import java.util.Date;

public class FavSellerView {

	private int id; 
	private String title; 
	private String content;
	private String comName;
	private int brn;
	private String repName;
	private String staffName; 
	private String phone;
	private String email;
	private String files;
	private String sellingUrl;
	private String telephone;
	private Date regDate;
	private Date appDate;
	private String titleImage;
	
	public FavSellerView() {
		// TODO Auto-generated constructor stub
	}
	
	
	public FavSellerView(int id, String title, String content, String comName, int brn, String repName,
			String staffName, String phone, String email, String files, String sellingUrl, String telephone, Date regDate,
			Date appDate, String titleImage) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.comName = comName;
		this.brn = brn;
		this.repName = repName;
		this.staffName = staffName;
		this.phone = phone;
		this.email = email;
		this.files = files;
		this.sellingUrl = sellingUrl;
		this.telephone = telephone;
		this.regDate = regDate;
		this.appDate = appDate;
		this.titleImage = titleImage;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public int getBrn() {
		return brn;
	}
	public void setBrn(int brn) {
		this.brn = brn;
	}
	public String getRepName() {
		return repName;
	}
	public void setRepName(String repName) {
		this.repName = repName;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public String getSellingUrl() {
		return sellingUrl;
	}
	public void setSellingUrl(String sellingUrl) {
		this.sellingUrl = sellingUrl;
	}
	public String gettelephone() {
		return telephone;
	}
	public void settelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getAppDate() {
		return appDate;
	}
	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}


	@Override
	public String toString() {
		return "FavSellerView [id=" + id + ", title=" + title + ", content=" + content + ", comName=" + comName
				+ ", brn=" + brn + ", repName=" + repName + ", staffName=" + staffName + ", phone=" + phone + ", email="
				+ email + ", files=" + files + ", sellingUrl=" + sellingUrl + ", telephone=" + telephone + ", regDate=" + regDate
				+ ", appDate=" + appDate + ", titleImage=" + titleImage + "]";
	}
	
	
	
}
