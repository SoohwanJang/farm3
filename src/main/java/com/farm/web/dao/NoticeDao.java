package com.farm.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.farm.web.entity.Notice;
import com.farm.web.entity.NoticeView;

@Mapper
public interface NoticeDao {
	
	@Select("select * from notice where ${field} like '%${query}%' order by id desc limit #{offset}, #{size}")
	List<Notice> getList(int offset, int size, String field, String query);

	@Select("select * from notice where id=${id}")
	Notice get(int id);
	
	@Insert("insert into notice (writerId,title,content,pub) values (2,#{title},#{content},#{pub})")
	int insert(Notice notice);
	
	@Delete("delete from notice where id in (${id})")
	int delete(String id);
	
	@Update("update notice set title=#{title}, content=#{content}, pub=#{pub} where id=${id}")
	int update(Notice notice);
	
	@Update("update notice set pub=1 where id in (${id})")
	int updatePub(String id);

	@Select("SELECT * FROM noticeview where id=${id}")
	NoticeView getComm(int id);

}
