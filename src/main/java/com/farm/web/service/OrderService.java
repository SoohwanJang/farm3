package com.farm.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.web.dao.DeliveryDao;
import com.farm.web.dao.OrderItemDao;
import com.farm.web.dao.OrderItemDao2;
import com.farm.web.entity.Delivery;
import com.farm.web.entity.OrderItemView;
import com.farm.web.entity.SimpleCountView;

/**
 * [Service] 주문관리
 * @author soo
 * @since 2019.10.202
 * 
 *
 */
@Service
public class OrderService {


	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private DeliveryDao deliveryDao;
	@Autowired
	private OrderItemDao2 orderItemDao2;
	
	
//	------------수환--------------
	// 판매자의 주문현황 list의 뷰를 위한 페이지
/**
 * 
 * @param id
 * @param page
 * @param status
 * @param field
 * @param query
 * @return
 */

	public List<OrderItemView> getOrderItemList(int id, Integer page, String status, String field, String query){
	
		int offset = (page-1)*10; // 1-> 0, 2-> 10, 3-> 20 이 되게 만들어야한다.
		int size = 10;
		
//		return orderItemDao.getList(offset, size, id, status, field, query);
		return orderItemDao2.getList(id, size, offset, status, field, query);
	}
	
	// 판매자의 주문 detail의 뷰를 위한 페이지
	public OrderItemView getOrderItemView1(int id) {
	
//		return orderItemDao.getView(id);
		return orderItemDao2.getView(id);
	}
	
	// 판매자가 상품을 보내고 회사와 송장번호를 첨부하는 작업
	public int sendItem(int dtlNum, int deliveryId, int waybillNum) {
		
//		return orderItemDao.updateWaybillNum(dtlNum, deliveryId, waybillNum);
		return orderItemDao2.updateWaybillNum(dtlNum, deliveryId, waybillNum);
		
	}
	
	// 판매자가 무통장 거래일 때 입금을 확인했을때
	public int confirmPay(int id) {
		
		Date payCDate = new Date();
		
		return orderItemDao.updatePayCDate(id,payCDate);
	}
	
	public List<Delivery> getDelivery() {
		return deliveryDao.getList();
	}
	
	
//******************지욱*******************
	public OrderItemView getOrderItemView(int id) {
		OrderItemView orderItem = orderItemDao.getView(id);
		
		return orderItem;
	}


	public List<OrderItemView> getMemberOIList(String uid){
		
		
		return orderItemDao.getListToUid(uid);
	}
	
	public int cancleOrder(int id){
		String field = "status";
		String query = "주문취소";

		return orderItemDao.updateStatus(id,field,query);
	}
	
	public List<SimpleCountView> getCount(String uid){
		
		return orderItemDao.getCount(uid);
	}
	//***************************************
	
}
