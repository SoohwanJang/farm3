package com.farm.web.controller.admin.board.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farm.web.entity.CustQnA;
import com.farm.web.entity.CustQnAView;
import com.farm.web.service.CustQnAService;

@RestController("apiCustQnAController")
@RequestMapping("/admin/board/qna/api")
public class CustQnAController {
	@Autowired
	private CustQnAService custQnaService;

	@GetMapping("list")
	public List<CustQnAView> list(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query) {
		
		List<CustQnAView> list = custQnaService.getList(page, field, query);
		
		return list;
	}
}