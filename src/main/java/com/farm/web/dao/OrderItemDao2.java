package com.farm.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farm.web.entity.OrderItemView;
import com.farm.web.param.WaybillNum;

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
		

		List<OrderItemView> testList = sqlSession.selectList("mybatis.mappers.orderItemMapper.getList", paramMap);
//		List<OrderItemView> testList = sqlSession.selectList("mybatis.mappers.orderItemMapper.getList", orderItemList);
		return testList;
	}
	
	public OrderItemView getView(int id) {
		
		return sqlSession.selectOne("mybatis.mappers.orderItemMapper.getView", id);
	}
	
	public int updateWaybillNum(int dtlNum, int deliveryId, int waybillNum) {
		
		WaybillNum waybillNumInfo = new WaybillNum(dtlNum, deliveryId, waybillNum);
		
		return sqlSession.update("mybatis.mappers.orderItemMapper.updateWaybillNum", waybillNumInfo);
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
		
		return sqlSession.insert("mybatis.mappers.orderItemMapper.insertError", map);
	}
}
