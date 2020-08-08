package com.farm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.farm.web.entity.Item;
import com.farm.web.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemService itemService;
	
	@GetMapping("list")
	public String list() {
		return "item/list";
	}
	
	@GetMapping("{id}")
	public String detail(@PathVariable int id,
			Model model) {
		
		Item item = itemService.get(id);
		model.addAttribute("i", item);
		return "item/detail";
	}
	

}
