package com.farm.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farm.web.dto.OrderItemDto;
import com.farm.web.dto.WaybillNum;
import com.farm.web.entity.OrderItemView;

@Repository
public class OrderItemDao2 {

	@Autowired
	private SqlSession sqlSession;
	
	public List<OrderItemView> getList(int id, int size, int offset, String status, String field, String query) {
		Map<String, Object> paramMap = new HashMap<String, Object>(); 
		paramMap.put("id", id); 
		paramMap.put("size", size);
		paramMap.put("offset", offset);
		paramMap.put("status", status);
		paramMap.put("field", field);
		paramMap.put("query", query);
		OrderItemDto orderItemList = new OrderItemDto();
		

//		List<OrderItemView> testList = sqlSession.selectList("com.farm.web.dao.OrderItemDao2.getList", paramMap);
		List<OrderItemView> testList = sqlSession.selectList("com.farm.web.dao.OrderItemDao2.getList", orderItemList);
		System.out.println(testList);
		
		return testList;
	}
	
	public OrderItemView getView(int id) {
		
		
		return sqlSession.selectOne("com.farm.web.dao.OrderItemDao2.getView", id);
	}
	
	public int updateWaybillNum(int dtlNum, int deliveryId, int waybillNum) {
		
		WaybillNum waybillNumInfo = new WaybillNum(dtlNum, deliveryId, waybillNum);
		
		return sqlSession.update("com.farm.web.dao.OrderItemDao2.updateWaybillNum", waybillNumInfo);
	}
	
	public int insertError() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderId", 55);
		map.put("itemId", 32);
		map.put("qty", 2);
		map.put("payMethod", "card");
		map.put("status", "입금완료");
		map.put("deliveryMemo", "잘 부탁드립니다");
		map.put("payDDate", "2020-09-19");
		
		return sqlSession.insert("com.farm.web.dao.OrderItemDao2.insertError", map);
	}
}
