package com.farm.web.dao;

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
	
	@Insert("insert into `Order`(memberId,destination) values(#{memberId},#{destination})")
	public int insert(Order order);
	
	@Update("")
	int update();
	
	@Delete("")
	int delete();

}
