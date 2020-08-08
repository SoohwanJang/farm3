package com.farm.web.controller.seller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farm.web.dao.CategoryDao;
import com.farm.web.entity.Category;

@RestController
@RequestMapping("/api/seller/category/")
public class CategoryController {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@GetMapping("sub-categories")
	public List<Category> getSubCategoryList(HttpServletRequest request, String sup){

		String subCAT_ = request.getParameter("sup");
		int subCAT = Integer.parseInt(subCAT_);
		
		List<Category> subCategoies = categoryDao.getSubList(subCAT);
				
		return subCategoies;
	}
	
	
}
