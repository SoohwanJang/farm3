package com.farm.web.service;

import java.util.List;

import com.farm.web.entity.Delivery;
import com.farm.web.entity.OrderItemView;

public interface OrderService {
	
	List<OrderItemView> getOrderItemList(int id, Integer page, String status, String field, String query);
	
	OrderItemView getOrderItemView1(int id);
	
	void sendItem(int dtlNum, int deliveryId, int waybillNum);
	
	int confirmPay(int id);
	
	List<Delivery> getDelivery();
}
