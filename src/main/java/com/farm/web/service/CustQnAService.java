package com.farm.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.web.dao.CustQnADao;
import com.farm.web.dao.MemberDao;
import com.farm.web.entity.CustQnA;
import com.farm.web.entity.CustQnAView;
import com.farm.web.entity.Member;

@Service
public class CustQnAService {

	@Autowired
	private CustQnADao custQnaDao;
	
	@Autowired
	private MemberDao memberDao;

	public List<CustQnAView> getList(Integer page, String field, String query) {
		int size = 10;
		int offset = (page-1)*size;
		
		return custQnaDao.getList(offset, size, field, query);
	}	

	public int delete(int[] id) {
		String ids = "";
		for(int i : id)
			ids += i+","; 
		ids = ids.substring(0,ids.length()-1);
		
		return custQnaDao.delete(ids);
	}

	public CustQnAView get(int id) {
		
		return custQnaDao.get(id);
	}

	public int update(CustQnA custQna) {

		return custQnaDao.update(custQna);
	}

	public int insert(CustQnAView custQnAview) {
		
		return custQnaDao.insert(custQnAview);
		
	}
	
public int insertss(CustQnA cqa,String uid) {
		
		Member member = memberDao.getByUid(uid); //해당되는 멤버를 불러와라
		int mid = member.getId(); //불러온 멤버에서 mid(pk)를 담고 
		cqa.setWriterId(mid); //writerId를 마저 적어준다.
		System.out.println("서비스: "+cqa);
		
		return custQnaDao.insertss(cqa);
		
	}
	
	
	

}
