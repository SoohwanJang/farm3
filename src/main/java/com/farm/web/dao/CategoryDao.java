package com.farm.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.farm.web.entity.Category;
import com.farm.web.entity.CategoryCountView;
import com.farm.web.entity.CategoryView;
import com.farm.web.entity.SellerCategoryCountView;

@Mapper
public interface CategoryDao {
	/******************************************윤호************************************************************/
	@Select("")
	CategoryView getView(int id);
	
	@Insert("")
	int insert();
	
	@Update("")
	int update();
	
	@Delete("")
	int delete();
	
	@Select("select * from categorycountview")
	List<CategoryCountView> getCountByCategory();
	/******************************************************************************************************/
	/*******************************************지욱********************************************************/
	@Select("select c.id,c.name,count(i.id) count\r\n" + 
			"from category c  \r\n" + 
			"left join category cc on cc.sup = c.id \r\n" + 
			"left join (select * from sellerproductview where uid='seller' and isdel=0) i on i.categoryId=cc.id\r\n" + 
			"where c.sup is null\r\n" + 
			"group by c.id,c.name;")
	List<SellerCategoryCountView> getSellerProductCountList();
	/******************************************************************************************************/
	/*****************************************성령***********************************************************/
	@Select("SELECT DISTINCT id,pName,sup FROM categoryview")
	List<CategoryView> getList();
	
	@Select("select * from category where sup=#{sup}")
	List<Category> getSubList(@Param("sup") int sup);

}

