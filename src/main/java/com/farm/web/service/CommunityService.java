package com.farm.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.web.dao.ApplyDao;
import com.farm.web.dao.CustQnADao;
import com.farm.web.dao.NoticeDao;
import com.farm.web.dao.ReviewDao;
import com.farm.web.entity.CustQnAView;
import com.farm.web.entity.Notice;
import com.farm.web.entity.ReviewView;
import com.farm.web.entity.SellerApply;

@Service
public class CommunityService {

	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private ApplyDao applyDao;
	
	@Autowired
	private CustQnADao custQnaDao;

	@Autowired
	private ReviewDao reviewDao;
	
	public List<Notice> getNoticeList(Integer page, String field, String query) {
		int size = 10;
		int offset = (page-1)*size;
		
		return noticeDao.getList(offset, size, field, query);
	}
	
	public List<SellerApply> getApplyList(Integer page, String field, String query) {
		int size = 10;
		int offset = (page-1)*size;
		
		return applyDao.getList(offset, size, field, query);
	}
	
	public List<CustQnAView> getCustQnAList(Integer page, String field, String query) {
		int size = 10;
		int offset = (page-1)*size;
		
		return custQnaDao.getList(offset, size, field, query);
	}
	
	public List<ReviewView> getReivewList(Integer page, String field, String query) {
		int size = 10;
		int offset = (page-1)*size;
		
		return reviewDao.getList(offset, size, field, query);
	}
}
