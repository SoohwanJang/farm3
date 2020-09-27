package com.farm.web.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.farm.web.dto.OrderItemDto;
import com.farm.web.entity.OrderItem;
import com.farm.web.entity.OrderItemView;

@Mapper
public interface OrderItemDao3 {

	/**
	 * 주문아이템 목록 조회
	 * @param orderItemDto 주문입력
	 * @return
	 */
	List<OrderItemView> getList(OrderItemDto orderItemDto);
	
	List<OrderItemView> getListAll(OrderItemDto orderItemDto);
	
	OrderItemView getView(int id);
	
	OrderItem getOrderItem(int id);
	
	int updateWaybillNum(int dtlNum, int deliveryId, int waybillNum);
	
	int insertError();
	
	int insert(OrderItem orderItem);
	
	int updatePayCDate(HashMap<String, Object> map);
	
	int getTotalCount(int id);
	
}
