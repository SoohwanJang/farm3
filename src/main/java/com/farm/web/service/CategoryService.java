package com.farm.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.web.dao.CategoryDao;
import com.farm.web.entity.CategoryCountView;

@Service
public class CategoryService {
	
	@Autowired
	CategoryDao categoryDao;

	public List<CategoryCountView> getCountByCategory() {
		List<CategoryCountView> list = categoryDao.getCountByCategory();
		
		int total = 0;
		for(CategoryCountView c : list)
			total += c.getCount();
		
		CategoryCountView tView = new CategoryCountView(0,"전체상품",total);
		list.add(0,tView);
		
		return list;
	}
	
}
