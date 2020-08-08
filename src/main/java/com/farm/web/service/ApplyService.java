package com.farm.web.service;

import com.farm.web.dao.ApplyDao;
import com.farm.web.dao.NoticeDao;
import com.farm.web.entity.AdminSellerView;
import com.farm.web.entity.Notice;
import com.farm.web.entity.SellerApply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyService {

	@Autowired
	private ApplyDao applyDao;
	
	public List<SellerApply> getList(Integer page, String field, String query) {
		int size = 10;
		int offset = (page-1)*size;
		
		return applyDao.getList(offset, size, field, query);
	}

	public SellerApply get(int id) {
			
			return applyDao.get(id);
		}
	
	
	public int delete(int[] id) {
		String ids = "";
		for(int i : id)
			ids += i+","; 
		ids = ids.substring(0,ids.length()-1);
		
		return applyDao.delete(ids);
	}
	
public int updateAccept(int id) {
		
		return applyDao.update(id);
	}

	public int updateReject(int id) {
		
		return applyDao.updateReject(id);
	}
	
	
	public List<SellerApply> getApplyList(Integer page, String field, String query) {
		int size = 10;
		int offset = (page-1)*size;
		
		return applyDao.getList(offset, size, field, query);
	}

	public int regSeller(SellerApply sellerApply) {
		
		
		return applyDao.insertRegSeller(sellerApply);
	}

	public SellerApply getApplyListDeatil(int id) {
		
		return applyDao.getApplyListDetail(id);
	}
	

}
