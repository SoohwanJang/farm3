package com.farm.web.controller.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.farm.web.dao.ItemQnADao;
import com.farm.web.dao.ReviewDao;
import com.farm.web.entity.Item;
import com.farm.web.entity.ItemNoticeVo;
import com.farm.web.entity.ItemOfDetail;
import com.farm.web.entity.ReviewNoticeVo;
import com.farm.web.service.DetailService;
import com.farm.web.service.ItemService;



@RequestMapping("/product/details")
@Controller
public class DetailController {

	@Autowired
	private DetailService detailService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	private ItemQnADao itemQnADao;
	
	@GetMapping("/{productId}")
	public String detail(
			@PathVariable("productId") int prId,
			Model model ,
			HttpSession session
			) {
		
		
		/*		
		 * 1. 디테일 초기상품 구성 화면 처리할 부분	
		 */
		model.addAttribute("itemId", prId);
		
		ItemOfDetail itemOfDetail = detailService.init(prId);
		model.addAttribute("itemOfDetail", itemOfDetail);
		
		/*
		 * 2. 리뷰 테이블 구현
		 */
		
		List<ReviewNoticeVo> reivewNotice = reviewDao.selectByItemId(prId);
		model.addAttribute("reivewNotice", reivewNotice);
		
		
		/* 
		 * 3. QnA 테이블 구현
		 */
		List<ItemNoticeVo> QnANotice = itemQnADao.selectByProductId(prId);
		model.addAttribute("QnANotice", QnANotice);
		
		
		/*
		 * 최근본 상품 
		 */
		Item recentItem = itemService.selectById(prId);
		List<Item> recentItems =  new ArrayList<Item>();
		
		
		List<Item> sessionItems = (List<Item>) session.getAttribute("recentItems");
		if(sessionItems == null) {
			recentItems.add(recentItem);
			session.setAttribute("recentItems", recentItems);
		}else {	
			sessionItems.add(recentItem);
			session.setAttribute("recentItems", sessionItems);
		}

		return "product.details";
		
	}

}
