package com.farm.web.controller.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.farm.web.entity.CustQnAView;
import com.farm.web.entity.Notice;
import com.farm.web.entity.NoticeView;
import com.farm.web.entity.ReviewView;
import com.farm.web.entity.SellerApply;
import com.farm.web.service.CommunityService;

@Controller("CommunityIndexController")
@RequestMapping("/community/")
public class IndexController {

	@Autowired
	CommunityService communityService;
	
	@GetMapping("index")
	public String index(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			Model model) {
		
		//Notice
		List<Notice> noticeList = communityService.getNoticeList(page, field, query);
		model.addAttribute("notice", noticeList);
		
		//Apply
		List<SellerApply> applyList = communityService.getApplyList(page, field, query);
		model.addAttribute("apply", applyList);
		
		//QnA
		List<CustQnAView> custQnaList = communityService.getCustQnAList(page, field, query);
		model.addAttribute("qna", custQnaList);
		
		//Review
		List<ReviewView> reviewList = communityService.getReivewList(page, field, query);
		model.addAttribute("review", reviewList);
		
		return "community.index";
	}

	
// Once you on click each title go throw to detail screen.
	
//	@GetMapping("{id}") //Notice Detail
//	public String detail(@PathVariable("id") int id, Model model) {
//		
//		NoticeView noticeView = noticeService.getComm(id);
//		model.addAttribute("n", noticeView);
//		
//		
//		return "community/notice/detail";
//	}
//	
//	@GetMapping("{id}") //Qna Detail
//	public String detail(@PathVariable("id") int id, Model model) {
//		
//		CustQnAView custQnaView = custQnaService.get(id);
//		model.addAttribute("q", custQnaView);
//		
//		return "community/qna/detail";
//	}
}
