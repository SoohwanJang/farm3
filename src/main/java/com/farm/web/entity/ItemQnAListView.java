package com.farm.web.entity;

public class ItemQnAListView extends ItemQnA{
	
	private String iName;
	private int iSellerId;
	private String mUid;
	private String mName;
	
	public ItemQnAListView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemQnAListView(String iName, int iSellerId, String mUid, String mName) {
		super();
		this.iName = iName;
		this.iSellerId = iSellerId;
		this.mUid = mUid;
		this.mName = mName;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public int getiSellerId() {
		return iSellerId;
	}

	public void setiSellerId(int iSellerId) {
		this.iSellerId = iSellerId;
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

	@Override
	public String toString() {
		return "ItemQnAListView [iName=" + iName + ", iSellerId=" + iSellerId + ", mUid=" + mUid + ", mName=" + mName
				+ ", toString()=" + super.toString() + "]";
	}

	
}
