package com.farm.web.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farm.web.dao.DeliveryDao;
import com.farm.web.dao.OrderItemDao;
import com.farm.web.dao.OrderItemDao3;
import com.farm.web.dto.OrderItemDto;
import com.farm.web.dto.PageInfoVo;
import com.farm.web.entity.Delivery;
import com.farm.web.entity.OrderItemView;
import com.farm.web.entity.SimpleCountView;
import com.farm.web.exception.FarmException;

/**
 * [Service] 주문관리
 * @author soo
 * @since 2019.10.202
 * 
 *
 */
@Primary
@Service
public class OrderServiceImpl{


	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private DeliveryDao deliveryDao;
	@Autowired
	private OrderItemDao3 orderItemDao3;
	
	
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
	
		// 한 페이지에 보여질 목록의 개수
		int size = 10;
		
		// 오프셋 구하기
		int offset = (page-1)*10; // 1-> 0, 2-> 10, 3-> 20 이 되게 만들어야한다.
		
		
		OrderItemDto orderItemDto = new OrderItemDto();
		orderItemDto.setId(id);
		orderItemDto.setStatus(status);
		orderItemDto.setField(field);
		orderItemDto.setQuery(query);
		orderItemDto.setSize(size);
		orderItemDto.setOffset(offset);
		
		
//		return orderItemDao.getList(offset, size, id, status, field, query);
		return orderItemDao3.getList(orderItemDto);
	}
	
	// 판매자의 주문 detail의 뷰를 위한 페이지
	public OrderItemView getOrderItemView1(int id) {
	
//		return orderItemDao.getView(id);
		return orderItemDao3.getView(id);
	}
	
	// 마지막 페이지와 페이지 오프셋을 얻기 위한 코드
	public PageInfoVo getPageInfo(int id, Integer page) {
		
		// 한 페이지에 보여질 목록의 개수
		int size = 10;
		// 한 페이지에 보여질 페이지의 개수
		int pageSize = 5;
		// 해당 판매자의 전체 주문아이템 수
		int totalCount = orderItemDao3.getTotalCount(id);
		// 마지막 페이지의 숫자
		int lastPage = 0;
		
		// 마지막 페이지를 구하는 코드
		if(totalCount%size != 0) {
			lastPage = (totalCount / size) + 1;
		}
		if(totalCount%size == 0) {
			lastPage = (totalCount / size);
		}
		
		// 페이지 오프셋(1~5 페이지는 오프셋 0, 6~10페이지는 오프셋 1)
		int pageOffset = 0;
		// 현재의 페이지오프셋을 구하는 코드
		if(page%pageSize != 0) {
			pageOffset = (page / pageSize);
		}
		if(page%pageSize == 0) {
			pageOffset = (page / pageSize) -1 ;
		}
		
		PageInfoVo pageInfo = new PageInfoVo(lastPage, pageOffset);
		
		return pageInfo;
	}
	
	// 판매자가 상품을 보내고 회사와 송장번호를 첨부하는 작업
	@Transactional
	public void sendItem(int dtlNum, int deliveryId, int waybillNum) throws FarmException {
		
//		orderItemDao.updateWaybillNum(dtlNum, deliveryId, waybillNum);
		orderItemDao3.updateWaybillNum(dtlNum, deliveryId, waybillNum);
		// 에러발생코드
		orderItemDao3.insertError();
		
		// 정상 코드
//		OrderItem orderItem = new OrderItem();
//		orderItem.setOrderId(58);
//		orderItem.setItemId(2);
//		orderItem.setQty(2);
//		orderItem.setPayMethod("card");
//		orderItem.setStatus("입금완료");
//		orderItem.setDeliveryMemo("잘 부탁 드립니다");
//		orderItem.setPayDDate(new Date());
//		orderItemDao3.insert(orderItem);
	}
	
	// 판매자가 무통장 거래일 때 입금을 확인했을때
	public int confirmPay(int id) {
		
		Date payCDate = new Date();
		HashMap<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("payCDate", payCDate);
		
		return orderItemDao3.updatePayCDate(map);
	}
	
	public List<Delivery> getDelivery() {
		return deliveryDao.getList();
	}
	
	
//******************지욱*******************
	public OrderItemView getOrderItemView(int id) {
		OrderItemView orderItem = orderItemDao3.getView(id);
		
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
