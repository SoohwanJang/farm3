package com.farm.web.controller.member;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farm.web.dao.ItemQnADao;
import com.farm.web.entity.ItemNoticeVo;
import com.farm.web.entity.ItemQnA;
import com.farm.web.service.ItemQnAService;

@RequestMapping("/product/details/itemQnA")
@RestController
public class ItemQnAController {

	@Autowired
	private ItemQnAService itemQnAService;
	
	@Autowired
	private ItemQnADao itemQnADao;

	// 더보기기능
	@GetMapping("/plus/{prId}")
	public List<ItemNoticeVo> plusItemQnA(
			@PathVariable("prId") int prId,
			@CookieValue(value = "ItemQnACount", defaultValue = "1", required = true) String ItemQnACount,
			HttpServletResponse response) {

		int NoticeCount = Integer.parseInt(ItemQnACount);

		int offset = ++NoticeCount * 10;
		String NoticeCount_ = Integer.toString(NoticeCount);
		Cookie cookie = new Cookie("ItemQnACount", NoticeCount_);
		cookie.setMaxAge(30);
		response.addCookie(cookie);
		
		List<ItemNoticeVo> list = itemQnAService.plusItemQnA(prId,offset);
		return list;

	}
	
	//내용 보여주기.
	@GetMapping("/{noticeId}")
	public ItemQnA plusItemId(
			@PathVariable(value = "noticeId" ,required =false) int noticeId){
		
		ItemQnA itemQnA = itemQnADao.selectById(noticeId);
		return itemQnA;

	}

}