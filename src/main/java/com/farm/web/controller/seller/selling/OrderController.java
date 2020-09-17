package com.farm.web.controller.seller.selling;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.farm.web.dao.MemberDao;
import com.farm.web.entity.Delivery;
import com.farm.web.entity.Member;
import com.farm.web.entity.OrderItem;
import com.farm.web.entity.OrderItemView;
import com.farm.web.service.OrderService;

@Controller("sellerOrderController")
@RequestMapping("/seller/selling/")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("list")
	public String list(
			@RequestParam(name = "p", defaultValue = "1") Integer page, 
			@RequestParam(name = "st", defaultValue = "") String status,
//			@RequestParam(name = "f", defaultValue = "iName") String field,
			@RequestParam(name = "f", defaultValue = "i.name") String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			HttpServletRequest request,
			Principal principal,
			Model model) {
		
		String uid = principal.getName();
		Member member = memberDao.getByUid(uid);
		int id =member.getId();
		
		List<OrderItemView> oiList = orderService.getOrderItemList(id, page, status, field, query);
		model.addAttribute("oiList", oiList);
		model.addAttribute("p", page);
		model.addAttribute("st", status);
		model.addAttribute("f", field);
		model.addAttribute("q", query);
		
		return "seller/selling/list";
	}
	
	@PostMapping("list")
	public String list2(
			HttpServletRequest request,
			Principal principal,
			Model model) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int page = Integer.parseInt(request.getParameter("p"));
		String status = request.getParameter("st");
		String field = request.getParameter("f");
		String query = request.getParameter("q");
		
		String uid = principal.getName();
		Member member = memberDao.getByUid(uid);
		int id =member.getId();
		List<OrderItemView> oiList = orderService.getOrderItemList(id, page, status, field, query);
		model.addAttribute("oiList", oiList);
		model.addAttribute("p", page);
		model.addAttribute("st", status);
		model.addAttribute("f", field);
		model.addAttribute("q", query);
		
		return "seller/selling/list";
	}
	
	@GetMapping("{dtlNum}")
	public String detail(@PathVariable("dtlNum") int dtlNum, Model model) {
		
		OrderItemView orderItem = orderService.getOrderItemView1(dtlNum);
		List<Delivery> deliveryList = orderService.getDelivery();
		model.addAttribute("oi", orderItem);
		model.addAttribute("dl", deliveryList);
		
		return "seller/selling/detail";
	}
	
	@PostMapping("{dtlNum}")
	public String detail2(@PathVariable("dtlNum") int dtlNum, 
			HttpServletRequest request, 
			Model model) {
		
		// 택배회사, 송장번호 첨부
		String deliveryId_ = request.getParameter("delivery");
		String waybillNum_ = request.getParameter("waybillNum");
		
		int deliveryId = Integer.parseInt(request.getParameter("delivery")); 
		int waybillNum = Integer.parseInt(request.getParameter("waybillNum"));
		orderService.sendItem(dtlNum, deliveryId, waybillNum);

		return "redirect:list";

	}
	

	
}
