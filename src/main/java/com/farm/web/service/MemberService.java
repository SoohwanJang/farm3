package com.farm.web.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.farm.web.dao.BasketDao;
import com.farm.web.dao.FavItemDao;
import com.farm.web.dao.FavSellerDao;
import com.farm.web.dao.MemberDao;
import com.farm.web.dao.OrderItemDao;
import com.farm.web.entity.AdminSellerView;
import com.farm.web.entity.FavItemView;
import com.farm.web.entity.FavSellerView;
import com.farm.web.entity.Member;
import com.farm.web.entity.SellerApply;
import com.farm.web.entity.SimpleCountView;

@Service
public class MemberService {
	
	@Autowired
	FavItemDao favItemDao;
	@Autowired
	MemberDao memberDao;
	@Autowired
	FavSellerDao favSellerDao;
	@Autowired
	BasketDao bastketDao;
	@Autowired
	OrderItemDao orderItemDao;

	public List<AdminSellerView> getAdminSellerList(Integer page, String field, String query) throws ClassNotFoundException, SQLException {
		int size = 10;
		int offset = (page - 1) * size;

		return memberDao.getAdminSellerList(page, query, field, offset, size);
	}

	public SellerApply getAdminAuthList(int id) throws ClassNotFoundException, SQLException {

		return memberDao.getAdminAuthList(id);
	}
	
	public List<Member> getAdminBuyerList(int page, String query, String field) throws ClassNotFoundException, SQLException {
		int size = 10;
		int offset = (page - 1) * size;
		
		return memberDao.getAdminBuyerList(page, query, field, offset, size);
	}

	public int getCountBuyer() throws ClassNotFoundException, SQLException {

		return memberDao.getCountBuyer();
	}

	public int getCountSeller() throws ClassNotFoundException, SQLException {

		return memberDao.getCountSeller();
	}

	public int getCountTotalMember() throws ClassNotFoundException, SQLException {

		return memberDao.getCountTotalMember();
	}

	public int unabledMember(String sellerId) throws ClassNotFoundException, SQLException {
		
		return memberDao.unabledMember(sellerId);
	}

	public int enabledMember(String sellerId) throws ClassNotFoundException, SQLException {
		
		return memberDao.enabledMember(sellerId);
	}
	
	//******지욱
	public Member getMember(String uid) { 
		
		return memberDao.getFromUid(uid);
		
	}

	public List<FavItemView> getFiViewList(String uid) {
		
		Member member = memberDao.getFromUid(uid);
		int memberid = member.getId();
		List<FavItemView> filist = favItemDao.getViewList(memberid);
		
		if(filist.isEmpty())
			filist=null;
		
		return filist;
	}
	
	public List<FavSellerView> getFarmViewList(String uid) {
		
		Member member = memberDao.getFromUid(uid);
		int memberid = member.getId();
		List<FavSellerView> fslist = favSellerDao.getFarmViewList(memberid);
		
		if(fslist.isEmpty())
			fslist=null;
		
		return fslist;
	}
	
	public int getBasketCount(String uid) {
		
		Member member = memberDao.getFromUid(uid);
		int memberid = member.getId();
		
		Integer bcount = bastketDao.getCountToMemer(memberid);
		if(bcount==null)
			bcount=0;
		
		return bcount;
	}

	public int getOrderItemCount(String uid) {

		List<SimpleCountView> colist = orderItemDao.getCount(uid);
		int total = 0;

		for(SimpleCountView c : colist) {
			if(c.getElement()=="배송중"||c.getElement()=="입금대기"||c.getElement()=="입금확인")
				total+=c.getCount();
		}
		
		return total;
	}

	public int editMember(String userId, Member member) {
		
		
		return memberDao.updateToMypage(member,userId);
		
	}
	
	//**지욱끝
	
	
	//수경
public int insert(Member member) {
		
		String pwd = member.getPwd();
		PasswordEncoder encoder = new BCryptPasswordEncoder();
      	member.setPwd(encoder.encode(pwd));
		
		return memberDao.insert(member);
	}
	
	public boolean validate(String uid, String pwd) {
	      Member member = memberDao.getByUid(uid);
	      if(member == null)
	         return false;
	      else if(!member.getPwd().equals(pwd))
	         return false;
	      
	      return true;
	   }


	public int selectId(Member member) {
		
		return memberDao.selectId(member);
	}

	public int selectEmail(Member member) {
		
		return memberDao.selectEmail(member);
	}

	public Member getId(Member member) {
		
		return memberDao.getId(member);
	}

	public int updatePwd(Member member) {
		
		String pwd = member.getPwd();
		PasswordEncoder encoder = new BCryptPasswordEncoder();
      	member.setPwd(encoder.encode(pwd));
		
		return memberDao.updatePwd(member);
	}

}
