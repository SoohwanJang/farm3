package com.farm.web.controller.admin.board;

import java.util.Date;
import java.util.List;


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
import org.springframework.web.bind.annotation.RestController;

import com.farm.web.entity.Notice;
import com.farm.web.entity.SellerApply;
import com.farm.web.service.ApplyService;
import com.farm.web.service.NoticeService;

@Controller("adminApplyController")
@RequestMapping("/admin/board/apply/")
public class SellerApplyController {
	
	@Autowired
	private ApplyService applyService;

	@GetMapping("list")
	public String list(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			Model model) {
		List<SellerApply> list = applyService.getList(page, field, query);
		model.addAttribute("list", list);
		
		return "admin.board.apply.list";
	}
	
	@GetMapping("{id}")
	public String detail(@PathVariable("id") int id, Model model) {
		
		SellerApply sellerApply = applyService.get(id);
		model.addAttribute("a", sellerApply);
		
		return "admin.board.apply.detail";
	}
	
	@GetMapping("update")
	@ResponseBody
	public int edit(int id, int value) {
		int res = 0;
		
		if(value == 1)
			res = applyService.updateAccept(id);
		else if(value == 2)
			res = applyService.updateReject(id);
		
		return res;
	}
	
	@GetMapping("del")
	@ResponseBody
	public List<SellerApply> del(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			int[] id) {
		
		int res = applyService.delete(id);
		List<SellerApply> list = applyService.getList(page, field, query);

		return list;
	}
}