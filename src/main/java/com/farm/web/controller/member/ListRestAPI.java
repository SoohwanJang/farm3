package com.farm.web.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farm.web.dao.ItemDao;
import com.farm.web.entity.HitItemListVo;
import com.farm.web.entity.Item;


@RequestMapping("/product/list")
@RestController
public class ListRestAPI {

	@Autowired
	ItemDao itemDao;
	
	@GetMapping("/items")
	public List<Item> list() {
		
		List<Item> list = itemDao.selectAll();
		
		return list;
	}
	
	@GetMapping("/items-hit")
	public List<HitItemListVo> hitList(){
		
		List<HitItemListVo> list = itemDao.hitItemList();
		
		return list;
		
	}
}
