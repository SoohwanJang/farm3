package com.farm.web.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.farm.web.entity.OrderItem;
import com.farm.web.entity.OrderItemView;
import com.farm.web.entity.SimpleCountView;

@Mapper
public interface OrderItemDao {

	@Select("select * from orderitemview"
			+ " where iSellerId = ${id} and status like '%${status}%' and ${field} like '%${query}%' LIMIT ${size} OFFSET ${offset}")
	List<OrderItemView> getList(int offset, int size, 
			int id, String status, String field, String query);
	
	@Select("select * from orderitemview where id=${id}")
	OrderItemView getView(int id);
	
	@Select("select * from orderitem where id=${id}")
	OrderItem get(int id);

	@Insert("insert into orderitem(itemId,qty,orderId,status) values(#{itemId},#{qty},#{orderId},#{status})")
	int insert(OrderItem orderItem);
	
	@Update("")
	int update();
	
	@Delete("")
	int delete();
	
	//***********************지욱*************************
		@Select("select * from orderitemview where mUid=#{uid} order by oRegDate desc")
		List<OrderItemView> getListToUid(String uid);

		@Update("update orderitem set ${field}='${query}' where id=#{id}")
		int updateStatus(int id,String field,String query);
		
		@Select("SELECT oiStatus element,COUNT(oiStatus) count FROM orderitemview where mUid = #{uid} group by oiStatus")
		List<SimpleCountView> getCount(String uid);
		
//		---------------수환------------
		//배송보내고 확인
		@Update("update orderitem set deliveryId=${deliveryId}, status='배송중', waybillNum=${waybillNum} where id=${dtlNum}")
		int updateWaybillNum(int dtlNum, int deliveryId, int waybillNum);
		
		//입금확인
		@Update("update orderitem set status='입금확인', payCDate=#{payCDate} where id=${id}")
		int updatePayCDate(int id, Date payCDate);
}
