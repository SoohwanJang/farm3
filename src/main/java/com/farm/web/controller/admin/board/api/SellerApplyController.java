package com.farm.web.controller.admin.board.api;

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

@RestController("apiApplyController")
@RequestMapping("/admin/board/apply/api")
public class SellerApplyController {
	
	@Autowired
	private ApplyService applyService;

	@GetMapping("list")
	public List<SellerApply> list(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query) {
		
		List<SellerApply> list = applyService.getList(page, field, query);
		
		return list;
	}
}