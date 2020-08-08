package com.farm.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.web.dao.ReviewDao;
import com.farm.web.entity.ReviewNoticeVo;

@Service
public class ReviewDetailService {

	@Autowired
	private ReviewDao reviewDao;
	
	public List<ReviewNoticeVo> plusReview(int offset, int prId) {


		List<ReviewNoticeVo> list = reviewDao.plusTenReviewRow(offset, prId);
		
		return list;
	}

}
