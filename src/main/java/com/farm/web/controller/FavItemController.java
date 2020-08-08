package com.farm.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.farm.web.entity.FavItemView;
import com.farm.web.service.FavItemService;

@Controller
@RequestMapping("/favitem/")
public class FavItemController {
	
	@Autowired
	FavItemService favItemService;
	
	@ResponseBody
	@GetMapping("contain")
	public int contain(@RequestParam(name = "id")int itemId,
			Principal principal) {
		String uName = principal.getName();
//		String uName = "yuno"; 
		
		int res = favItemService.contain(itemId,uName);
		
		return res;
	}
	
}
