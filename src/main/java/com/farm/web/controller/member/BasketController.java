package com.farm.web.controller.member;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.farm.web.entity.BasketPayView;
import com.farm.web.entity.BasketView;
import com.farm.web.entity.OrderSheet;
import com.farm.web.service.BasketService;

@Controller("MemberBasketController")
@RequestMapping("/member/basket")
public class BasketController {
	@Autowired
	BasketService basketService;
	
	@GetMapping("pay/{selectRows}")
	public String pay(@PathVariable int[] selectRows,
			Principal principal,
			Model model) {
		String uName = principal.getName();
//		String uName = "yuno";
		
		// ids 유효성 검사 // 내 카트에 있는 상품을 주문하는지
		if(!basketService.isAllContain(uName,selectRows))
			return "err";
		
		List<BasketPayView> payList = basketService.getPayList(uName,selectRows);
		model.addAttribute("pl",payList);
		model.addAttribute("m",payList.get(0));
		
		Map<String, Integer> total = new HashMap<>();
		
		int totalPrice = 0;
		int totalFee = 0;
		for(BasketPayView p : payList) {
			totalPrice += p.getPrice()*p.getQty();
			totalFee += p.getDeliveryFee();
		}
		total.put("tp", totalPrice);
		total.put("tf", totalFee);
		
		model.addAllAttributes(total);
		
		String idList = "";
		for(int i : selectRows)
			idList += i+",";
		idList = idList.substring(0, idList.length()-1);
		
		model.addAttribute("idList",idList);
		
		return "member.basket.pay";
	}
	
	
	@GetMapping("list")
	public String list(Principal principal,
			Model model) {
		String uName = principal.getName();
//		String uName = "yuno";
		int totalPrice = 0;
		int totalDf = 0;
		
		System.out.println(uName);
		
		List<BasketView> basketList = basketService.getList(uName);
		for(BasketView bv : basketList) {
			totalPrice += bv.getPrice()*bv.getQty();
			totalDf += bv.getDeliveryFee();
		}
		System.out.println(basketList);
		
		Map<String, Integer> price = new HashMap<>();
		price.put("totalPrice", totalPrice);
		price.put("totalDf", totalDf);
		
		model.addAllAttributes(price);
		model.addAttribute("bl",basketList);
		
		return "member.basket.list";
	}
	
	@ResponseBody
	@GetMapping("del")
	public int del(@RequestParam(name = "srs")int[] selectRows) {
		int res=0;
		
		res = basketService.delList(selectRows);
		
		return res;
	}
	
	@ResponseBody
	@GetMapping("update")
	public int update(int id,int qty) {
		int res=0;
		
		res = basketService.update(id,qty);
		
		return res;
	}
	
	@ResponseBody
	@PostMapping("order")
	public int order(@RequestBody OrderSheet orderSheet,
			Principal principal){
		String uName = principal.getName();
//		String uName = "yuno";
		
		int res = basketService.order(orderSheet,uName);
		
		return res;
	}
	
	
}
