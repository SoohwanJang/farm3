package com.farm.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.farm.web.service.BasketService;

@Controller
@RequestMapping("/basket/")
public class BasketController {
	
	@Autowired
	BasketService basketService;
	
	@ResponseBody
	@GetMapping("contain")
	public int contain(@RequestParam(name = "id")int itemId,
			int qty,
			Principal principal) {
		String uName = principal.getName();
//		String uName = "yuno";
		
		int res = basketService.contain(itemId,qty,uName);
		
		return res;
	}
	
	@ResponseBody
	@GetMapping("append")
	public int append(@RequestParam(name = "id")int itemId,
			int qty,
			Principal principal) {
		String uName = principal.getName();
//		String uName = "yuno";
		
		int res = basketService.append(itemId,qty,uName);
		
		return res;
	}
	
	@ResponseBody
	@GetMapping("containforce")
	public int containforce(@RequestParam(name = "id")int itemId,
			int qty,
			Principal principal) {
		String uName = principal.getName();
//		String uName = "yuno";
		
		int res = basketService.containforce(itemId,qty,uName);
		
		return res;
	}
	
	

}
