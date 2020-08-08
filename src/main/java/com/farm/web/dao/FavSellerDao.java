package com.farm.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.farm.web.entity.FavSellerView;

@Mapper
public interface FavSellerDao {

	
//	@Select("select * from FavItem where memberId = #{memberId}")
//	List<FavItem> getListTomemberId(int memberId);
//
//	@Insert("insert into FavItem(itemId,memberId) values(#{itemId},#{memberId})")
//	int insert(int itemId, int memberId);
//
//	@Delete("delete from FavItem where id=#{id}")
//	void delete(int id);
	
	//지욱
	@Select("select * from FavSellerView where memberId = #{memberId} ORDER BY regdate")
	List<FavSellerView> getFarmViewList(int memberId);
	
}
