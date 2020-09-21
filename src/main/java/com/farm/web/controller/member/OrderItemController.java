package com.farm.web.controller.member;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.farm.web.entity.OrderItemView;
import com.farm.web.entity.SimpleCountView;
import com.farm.web.service.OrderServiceImpl;

@Controller
@RequestMapping("/member/orderitem/")
public class OrderItemController {
	
	@Autowired
	private OrderServiceImpl orderservice;
	
	@GetMapping("list")
	public String list(Principal principal,Model model) {
		
		String uid = principal.getName();
		List<OrderItemView> oilist= orderservice.getMemberOIList(uid);
		model.addAttribute("oilist", oilist);
		
		List<SimpleCountView> colist = orderservice.getCount(uid);
		model.addAttribute("colist", colist);

		
		return "member.orderitem.list";
	}
	
	@GetMapping("cancle")
	public String cancle(Principal principal,
							@RequestParam(name = "id",defaultValue="0") int id) {
		
		String uid = principal.getName();

		orderservice.cancleOrder(id);
		
		
		return "redirect:list";
	}
}
