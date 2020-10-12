package com.farm.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.farm.web.entity.AdminSellerView;
import com.farm.web.entity.SellerApply;

@Mapper
public interface ApplyDao {
	
	@Select("select * from sellerapply where ${field} like '%${query}%' order by regDate desc limit #{offset}, #{size}")
	List<SellerApply> getList(int offset, int size, String field, String query);
	
	@Select("select * from sellerapply where id=${id}")
	SellerApply get(int id);
	
	@Delete("delete from sellerapply where id=${id}")
	int delete(String ids);
	
	@Update("update sellerapply set appDate=CURRENT_TIMESTAMP where id=${id}")
	int update(int id);

	@Update("update sellerapply set appDate=null where id=${id}")
	int updateReject(int id);
	
	@Select("select * from sellerapply where id=${id}")
	List<AdminSellerView> getApplyList(int id);

	@Insert("insert into sellerapply (id,title, content, comName, brn, repName, staffName, phone, telephone, email, files, sellingUrl, titleImage) "
			+ "values(#{id},#{title},#{content},#{comName},#{brn},#{repName},#{staffName},#{phone},#{telephone},#{email},#{files},#{sellingUrl},#{titleImage})")
	int insertRegSeller(SellerApply sellerApply);

	@Select("SELECT * FROM sellerapply where id=${id}")
	SellerApply getApplyListDetail(int id);
}
