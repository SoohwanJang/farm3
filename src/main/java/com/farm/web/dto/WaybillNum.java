package com.farm.web.dto;

public class WaybillNum {

	private int dtlNum;
	private int deliveryId;
	private int waybillNum;
	
	public WaybillNum() {
		// TODO Auto-generated constructor stub
	}

	public WaybillNum(int dtlNum, int deliveryId, int waybillNum) {
		super();
		this.dtlNum = dtlNum;
		this.deliveryId = deliveryId;
		this.waybillNum = waybillNum;
	}

	public int getDtlNum() {
		return dtlNum;
	}

	public void setDtlNum(int dtlNum) {
		this.dtlNum = dtlNum;
	}

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public int getWaybillNum() {
		return waybillNum;
	}

	public void setWaybillNum(int waybillNum) {
		this.waybillNum = waybillNum;
	}

	@Override
	public String toString() {
		return "WaybillNum [dtlNum=" + dtlNum + ", deliveryId=" + deliveryId + ", waybillNum=" + waybillNum + "]";
	}
	
	
}
