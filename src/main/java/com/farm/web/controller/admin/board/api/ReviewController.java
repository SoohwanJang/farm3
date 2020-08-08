package com.farm.web.controller.admin.board.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farm.web.entity.ReviewView;
import com.farm.web.service.ReviewService;

@RestController("apiReviewController")
@RequestMapping("/admin/board/review/api")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;

	@GetMapping("list")
	public List<ReviewView> list(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query) {
		List<ReviewView> list = reviewService.getList(page, field, query);
		
		return list;
	}
	
}