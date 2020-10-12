package com.farm.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.farm.web.entity.Basket;
import com.farm.web.entity.BasketPayView;
import com.farm.web.entity.BasketView;

@Mapper
public interface BasketDao {

	@Select("select * from basketview where memberId = #{memberId}")
	List<BasketView> getList(int memberId);

	@Select("select * from basketview where memberId=#{memberId} and id in(${idList})")
	List<BasketPayView> getPayList(int memberId, String idList);
	
	@Update("update basket set ${column} = #{value} where id = #{id}")
	int update(int id, String column, Object value);

	@Insert("insert into basket(itemId,memberID,qty) values(#{itemId},#{memberId},#{qty})")
	int insert(int itemId, int memberId, int qty);

	@Delete("delete from basket where id in (${List})")
	int delList(String idList);

	@Select("select count(*) count from basket where memberId=#{memberId} and id in(${selectRows});")
	int getCount(int memberId, String selectRows);
	
	@Select("select * from basket where id = #{id}")
	Basket get(int id);
	
	@Select("select * from basket where memberId = #{memberId} order by regDate desc limit 1")
	Basket getToMember(int memberId);
	
	//지욱
	@Select("SELECT count(*) count FROM basket where memberId = ${memberId}")
	Integer getCountToMemer(int memberId);
	


}
