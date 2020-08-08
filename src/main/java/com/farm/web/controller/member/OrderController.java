package com.farm.web.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/order/")

public class OrderController {
	
	@GetMapping("list")
	public String list() {
		return "member.order.list";
	}
	
	@GetMapping("check")
	public String check(int c,
			Model model) {
		model.addAttribute("check",c);
		return "member.order.check";
	}	
	
	
}
