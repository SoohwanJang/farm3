package com.farm.web.controller.admin.board;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.farm.web.entity.Review;
import com.farm.web.entity.ReviewView;
import com.farm.web.service.ReviewService;

@Controller("adminReviewController")
@RequestMapping("/admin/board/review/")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;

	@GetMapping("list")
	public String list(@RequestParam(name = "p", defaultValue = "1") int page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			Model model) {
		List<ReviewView> list = reviewService.getList(page, field, query);
		model.addAttribute("list", list);
		
		return "admin.board.review.list";
	}
	
	@GetMapping("{id}")
	public String detail(@PathVariable("id") int id, Model model) {
		
		Review review = reviewService.get(id);
		model.addAttribute("r", review);
		
		return "admin.board.review.detail";
	}
	
	@GetMapping("del")
	@ResponseBody
	public List<ReviewView> del(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			int[] id) {
		
		int res = reviewService.delete(id);
		List<ReviewView> list = reviewService.getList(page, field, query);
		
		return list;
	}
}