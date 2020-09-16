package com.farm.web.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.farm.web.dao.ItemDao;
import com.farm.web.dao.ReviewDao;
import com.farm.web.entity.ItemOfDetail;
import com.farm.web.entity.DTO.ReviewViewofIndex;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	ReviewDao reviewDao;
	
	@Autowired
	ItemDao itemDao;

	@Autowired
	private DataSource dataSource;
	
	@GetMapping("index")
	public String index(Model model) {

		// 현재 비지니스로직이없이 바로 데이터를 바인딩해주기때문에 Application Layer를 만들지않음
		List<ReviewViewofIndex> reviews = reviewDao.indexOfReviews();
		model.addAttribute("reviews", reviews);
		
		
		List<ItemOfDetail> items = itemDao.itemOfIndex("곡물");
		model.addAttribute("items", items);
		return "root.index";
	}
	
	@ResponseBody
	@GetMapping("index/items")
	public List<ItemOfDetail> selectByCategoryName(@RequestParam(name = "category") String categoryName, Model model) {
		
		
		List<ItemOfDetail> items = itemDao.itemOfIndex(categoryName);
		return items;
		
	}

}
