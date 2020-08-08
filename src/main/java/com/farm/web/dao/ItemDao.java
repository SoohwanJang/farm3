package com.farm.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.farm.web.entity.HitItemListVo;
import com.farm.web.entity.Item;
import com.farm.web.entity.ItemOfDetail;
import com.farm.web.entity.ItemView;
import com.farm.web.entity.SellerItemView;

@Mapper
public interface ItemDao {

	// 성일 - 주현 //
	@Select("select * from Item where pub =1 and isdel =0 order by startDate desc")
	List<Item> publicNewItemAll();

	@Select("select * from hitItemView")
	List<HitItemListVo> hitItemList();

	@Select("SELECT id,sellerId,categoryId,originId,name,regName,detail,price,regDate,startDate,endDate,leadTime,image,tag,pub FROM Item WHERE id = ${itemId}")
	Item selectById(int itemId);

	@Select("SELECT * FROM Item where pub =1 and isdel =0")
	List<Item> selectAll();

	@Select("SELECT * FROM ItemView WHERE ${field} LIKE '%${query}%' AND pub =1 and isdel = 0 ORDER BY startDate asc limit #{offset}, #{size}")
	List<ItemView> getList3(int page, String query, String field, int offset, int size)
			throws ClassNotFoundException, SQLException;

	@Select("SELECT COUNT(*) FROM Item WHERE pub = 1 AND isdel = 0 ORDER BY startDate DESC")
	int select() throws ClassNotFoundException, SQLException;

	@Select("SELECT * FROM ItemOfDetailView where id = ${itemId}")

	ItemOfDetail itemOfDetail(int itemId);
	
	@Select("SELECT * FROM farm.ItemOfDetailView where subCategory = #{subCategory} limit 3")
	List<ItemOfDetail> itemOfIndex(String categoryName);
	
	// 전체 메뉴
	@Select("SELECT * FROM ItemView WHERE ${field} LIKE '%${query}%' ORDER BY startDate asc limit #{offset}, #{size}")
	List<ItemView> getList4(int page, String query, String field, int offset, int size);

	/******************************************
	 * 윤호
	 ************************************************************/
	@Select("select * from ItemView where ${field} like '%${query}%' and catgPName like '%${catg}%' LIMIT #{offset},#{size}")
	List<ItemView> getList(int size, int offset, String field, String query, String catg);

	/**** 수환 ***/

	@Select("select distinct name from Item where sellerId=${id}")
	List<Item> getList2(int id);

	/**** 수환 끝 ***/

	@Select("select * from Item where id=${id}")
	Item get(int id);

	@Insert("")
	int insert();

	@Update("")
	int update();

	@Delete("")
	int delete();

	@Select("select count(*) from ItemView where ${field} like '%${query}%' and catgPName like '%${catg}%'")
	int getCount(String query, String field, String catg);

	@Update("update Item set isdel = 1 where id in (${selectRows})")
	int deleteSelectRows(String selectRows);

	/******************************************************************************************************/
	/*******************************************
	 * 지욱
	 ********************************************************/
	@Select("SELECT * FROM SellerProductView where isDel=0 and uid=#{uid} and ${field} LIKE '%${query}%' and firstcatg Like '%${category}%' "
			+ "ORDER BY regDate DESC LIMIT ${size} OFFSET ${offset}")
	List<SellerItemView> getSellerProductList(String query, String field, String category, @Param("offset") int offset,
			@Param("size") int size, @Param("uid") String uid);

	@Select("SELECT * FROM SellerProductView WHERE id=#{id}")
	SellerItemView getSellerProduct(int id);

	@Update("UPDATE Item SET isdel=1 WHERE id=#{id}")
	int SellerProductDelete(int id);

	@Update("UPDATE Item SET pub=${pub} WHERE id=${id}")
	int SellerProductUpdatePub(int id, boolean pub);

	@Insert("INSERT INTO Item(sellerId,categoryId,originId,name,regName,detail,price,startDate,endDate,image,tag,deliveryFee)"
			+ "values(#{sellerId},#{categoryId},#{originId},#{name},#{regName},#{detail},#{price},#{startDate},#{endDate},#{image},#{tag},#{deliveryFee})")
	int insertSellerProduct(Item item);

	// 아이템 등록한 후, 등록된 아이템의 id를 얻어오는 쿼리
	@Select("SELECT * FROM Item WHERE sellerId=#{sellerId} and name=#{name} and regName=#{regName} ")
	Item getItemId(int sellerId, String name, String regName);

	/******************************************************************************************************/

}