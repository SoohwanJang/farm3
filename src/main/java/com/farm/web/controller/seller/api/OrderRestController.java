package com.farm.web.controller.seller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farm.web.service.OrderService;

@RestController("sellerOrderRestController")
@RequestMapping("/api/seller/")
public class OrderRestController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("confirm")
	public int cdate(@RequestParam(name = "id") String id_) {
		int result = 0;
		int id = Integer.parseInt(id_);
		result = orderService.confirmPay(id);
		
		return result;
	}
	

}
