package com.farm.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.farm.web.entity.CustQnA;
import com.farm.web.entity.CustQnAView;
import com.farm.web.entity.Review;

@Mapper
public interface CustQnADao {

	@Select("select * from custqnaview where ${field} like '%${query}%' order by regDate desc limit #{offset}, #{size}")
	List<CustQnAView> getList(int offset, int size, String field, String query);

	@Delete("delete from custqna where id in (${id})")
	int delete(String ids);

	@Select("select * from custqnaview where id=${id}")
	CustQnAView get(int id);

	@Update("update custqna set contentA=#{content}, regDateA=CURRENT_TIMESTAMP where id=${id}")
	Integer update(CustQnA custQna);

	@Insert("")
	int insert(CustQnAView custQnAview);
	
	@Insert("insert into custqna(writerId,title,content) values(#{writerId},#{title},#{content})")
	int insertss(CustQnA cqa);

}
