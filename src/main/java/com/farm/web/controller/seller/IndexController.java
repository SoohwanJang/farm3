package com.farm.web.controller.seller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("SellerIndexController")
@RequestMapping("/seller/")
public class IndexController {

	@GetMapping("index")
	public String index() {
		
		return "seller/seller";
	}
}
