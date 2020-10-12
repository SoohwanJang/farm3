package com.farm.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.farm.web.entity.AdminSellerView;
import com.farm.web.entity.Member;
import com.farm.web.entity.SellerApply;

@Mapper
public interface MemberDao {
	
	@Select("SELECT * FROM adminseller WHERE ${field} LIKE '%${query}%' ORDER BY id ASC limit #{offset}, #{size}")
	List<AdminSellerView> getAdminSellerList(int page, String query, String field, int offset, int size) throws ClassNotFoundException, SQLException;
	
	@Select("SELECT a.id, s.id, a.comName, s.comName, s.brn, s.repName, s.staffName, s.phone, s.email, s.sellingUrl FROM adminseller AS a right JOIN sellerapply AS s ON a.id = s.id")
	SellerApply getAdminAuthList(int id) throws ClassNotFoundException, SQLException;

	@Select("select * from member where id = #{id}")
	Member get(int id);
	
	@Select("SELECT * FROM member WHERE role = 'ROLE_MEMBER' AND ${field} LIKE '%${query}%' ORDER BY id ASC limit #{offset}, #{size}")
	List<Member> getAdminBuyerList(int page, String query, String field, int offset, int size) throws ClassNotFoundException, SQLException;
	
	//  회원 수 조회
	@Select("SELECT COUNT(*) FROM member WHERE role = 'ROLE_MEMBER'")
	int getCountBuyer() throws ClassNotFoundException, SQLException;

	@Select("SELECT COUNT(*) FROM member WHERE role = 'ROLE_SELLER'")
	int getCountSeller() throws ClassNotFoundException, SQLException;
	
	@Select("SELECT COUNT(*) FROM member")
	int getCountTotalMember() throws ClassNotFoundException, SQLException;

	// 회원 삭제
//	@Delete("DELETE FROM Member WHERE uid = #{uid}")
//	int delete(String uid);
	
	// 회원 권한 제거
	@Update("UPDATE member SET enabled = 0 WHERE id = #{sellerId}")
	int unabledMember(String sellerId) throws ClassNotFoundException, SQLException;
	
	// 회원 권한 부여
	@Update("UPDATE member SET enabled = 1 WHERE id = #{sellerId}")
	int enabledMember(String sellerId) throws ClassNotFoundException, SQLException;

	@Select("select * from member where uid=#{uid}")
	Member getByUid(String uid);

	//*******************************지욱******************************
	@Select("select * from member where uid=#{uid}")
	Member getFromUid(String uid);
	
	@Update("update member set email=#{m.email}, address=#{m.address} , mobile=#{m.mobile} , phone = #{m.phone} where uid = #{userId}")
	int updateToMypage(@Param("m")Member member,String userId);
	
	//회원가입 - 수경
	@Insert("insert into member (uid, pwd, name, email, address, mobile, phone, role) values (#{uid},#{pwd},#{name},#{email},#{address},#{mobile},#{phone},#{role});")
	int insert(Member member);

	@Select("select count(uid) from member where uid=#{uid}")
	int selectId(Member member);

	@Select("select count(email) from member where email=#{email}")
	int selectEmail(Member member);

	@Select("select * from member where email=#{email}")
	Member getId(Member member);

	@Update("update member set pwd=#{pwd} where uid=#{uid} and email=#{email}")
	int updatePwd(Member member);
	
	//판매자 권한 부여
	@Update("update member set role='ROLE_SELLER' where id=${id}")
	int updateSeller(int id);
}
