package com.farm.web.controller.member;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farm.web.dao.ReviewDao;
import com.farm.web.entity.Review;
import com.farm.web.entity.ReviewNoticeVo;
import com.farm.web.service.ReviewService;

@RequestMapping("/product/details/review/")
@RestController
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired 
	private ReviewDao reviewDao;
	
	//더보기기능
	@GetMapping("plus/{prId}")
	public List<ReviewNoticeVo> plusReview(
			@PathVariable("prId") int prId,
			@CookieValue(value = "reviewCount",defaultValue = "1",required = true)String reviewCount,
			HttpServletResponse response) {
		
		int NoticeCount = Integer.parseInt(reviewCount);
		
		int offset = ++NoticeCount * 10;
		
		String NoticeCount_ = Integer.toString(NoticeCount);
		Cookie cookie = new Cookie("reviewCount", NoticeCount_);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		List<ReviewNoticeVo> list = reviewService.plusReview(offset,prId);
		return list;
		
	}
	
	
	@GetMapping("notice")
	public Review plusReview(
			@RequestParam(value = "itemId",required = false)int itemId,
			@RequestParam(value = "noticeId",required = false)int noticeId){
		
		
		Review review = reviewDao.selectByReviewIdAndPrId(noticeId,itemId);
			
		return review;
		
	}
	
}
