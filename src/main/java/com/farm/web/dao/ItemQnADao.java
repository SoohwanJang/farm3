package com.farm.web.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.farm.web.entity.ItemNoticeVo;
import com.farm.web.entity.ItemQnA;
import com.farm.web.entity.ItemQnAListView;

@Mapper
public interface ItemQnADao {

	@Select("select * from ItemQnAListView "
			+ "where iSellerId = ${id} and ${field} like '%${query}%' LIMIT #{size} OFFSET ${offset}")
	List<ItemQnAListView> getList(@Param("offset") int offset, @Param("size") int size, int id, int page, String query, String field);
	
	@Select("select * from ItemQnA where id=#{id}")
	ItemQnA get(int id);
	
	@Insert("insert into "
			+ "ItemQnA(writerId, itemId, title, content, regDate, image) "
			+ "values(${writerId}, ${itemId}, #{title}, #{content}, #{regDate}, #{image})")
	ItemQnA insert(ItemQnA itemQnA);
	
	@Update("update ItemQnA set contentA = #{data}, regDateA = #{date} where id = ${id}")
	int update(int id, String data, Date date);
	
	/* 성일 detail*/
	@Select("SELECT * FROM detailQnAListView where itemId = ${itemId} limit 10")
	List<ItemNoticeVo> selectByProductId(int itemId);
	
	@Select("SELECT * FROM ItemQnA where id = ${noticeId}")
	ItemQnA selectById(int noticeId);
	
	@Select("SELECT id,writerId,itemId,title,content,regDate,image,contentA,regDateA,hit FROM ItemQnA limit 10")
	List<ItemQnA> selectAll();
	
	@Select("call plusQnA(${itemId},${offset})")
	List<ItemNoticeVo> plusTenItemQnA(int itemId, int offset);
	
	/* 성일 detail*/
	@Insert("INSERT INTO ItemQnA (writerId,itemId,title,content,image,contentA) "
			+ "VALUE(${ItemQnA.writerId},${ItemQnA.itemId},#{ItemQnA.title},#{ItemQnA.content},#{ItemQnA.image},#{ItemQnA.contentA})")
	int InsertItemQnA(ItemQnA itemQnA);
	
}
