package com.farm.web.entity;

public class OrderSheet {
	private String destination;
	private String method;
    private String deliveryMemo;
    private String selectRows;
    private String addressCheck;
    
    public OrderSheet(){}
    
	public OrderSheet(String destination, String method, String deliveryMemo, String selectRows, String addressCheck) {
		super();
		this.destination = destination;
		this.method = method;
		this.deliveryMemo = deliveryMemo;
		this.selectRows = selectRows;
		this.addressCheck = addressCheck;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getDeliveryMemo() {
		return deliveryMemo;
	}

	public void setDeliveryMemo(String deliveryMemo) {
		this.deliveryMemo = deliveryMemo;
	}

	public String getSelectRows() {
		return selectRows;
	}

	public void setSelectRows(String selectRows) {
		this.selectRows = selectRows;
	}

	public String getAddressCheck() {
		return addressCheck;
	}

	public void setAddressCheck(String addressCheck) {
		this.addressCheck = addressCheck;
	}

	@Override
	public String toString() {
		return "OrderSheet [destination=" + destination + ", method=" + method + ", deliveryMemo=" + deliveryMemo
				+ ", selectRows=" + selectRows + ", addressCheck=" + addressCheck + "]";
	}
    
}
