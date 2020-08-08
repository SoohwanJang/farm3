package com.farm.web.controller.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.farm.web.entity.NoticeView;
import com.farm.web.entity.ReviewView;
import com.farm.web.service.ReviewService;

@Controller("CommunityReviewController")
@RequestMapping("/community/review/")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;

	@GetMapping("list")
	public String list(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			Model model) {
		
		
		List<ReviewView> review = reviewService.getList(page, field, query);
		model.addAttribute("review", review);
		
		return "community.review.list";
	}
	
	@GetMapping("{id}")
	public String detail(@PathVariable("id") int id, Model model) {
		
		ReviewView reviewView = reviewService.get(id);
		model.addAttribute("r", reviewView);
		
		return "community.review.detail";
	}
}
