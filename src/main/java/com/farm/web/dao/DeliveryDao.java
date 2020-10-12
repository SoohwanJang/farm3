package com.farm.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.farm.web.entity.Delivery;

@Mapper
public interface DeliveryDao {
	
	@Select("select * from delivery")
	List<Delivery> getList();
}
