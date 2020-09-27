package com.farm.web.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.farm.web.entity.Order;

@Mapper
public interface OrderDao {
	
	
	
	@Select("select * from `Order` where memberId = ${memberId} order by regDate desc Limit 1")
	public Order get(int memberId);
	
	@Insert("insert into `Order`(memberId,destination,payMethod,dueDate,cfDate,memo) values(#{memberId},#{destination},#{payMethod}),#{dueDate},#{cfDate},#{memo}")
	public int insert(Order order);
	
	@Update("update `order` set cfDate=#{cfDate} where id=#{id} ")
	int update(HashMap<String, Object> map);
	
	@Delete("")
	int delete();

}
