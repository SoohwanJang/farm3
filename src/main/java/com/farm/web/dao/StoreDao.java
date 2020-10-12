package com.farm.web.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreDao {
	/*******************************************지욱********************************************************/
	@Insert("INSERT INTO store(itemId,qty)"
			+ "values(#{itemId},#{qty})")
	int insert(int itemId,int qty);
	/******************************************************************************************************/
}
