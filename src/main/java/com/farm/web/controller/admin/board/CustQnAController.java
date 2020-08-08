package com.farm.web.controller.admin.board;

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

import com.farm.web.entity.CustQnA;
import com.farm.web.entity.CustQnAView;
import com.farm.web.entity.Notice;
import com.farm.web.entity.Review;
import com.farm.web.entity.ReviewView;
import com.farm.web.service.CustQnAService;
import com.farm.web.service.NoticeService;

@Controller("adminCustQnAController")
@RequestMapping("/admin/board/qna/")
public class CustQnAController {
	
	@Autowired
	private CustQnAService custQnaService;

	@GetMapping("list")
	public String list(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			Model model) {
		List<CustQnAView> list = custQnaService.getList(page, field, query);
		model.addAttribute("list", list);
		
		return "admin.board.qna.list";
	}
	
	@GetMapping("{id}")
	public String detail(@PathVariable("id") int id, Model model) {
		
		CustQnAView custQna = custQnaService.get(id);
		model.addAttribute("q", custQna);
		
		return "admin.board.qna.detail";
	}
	
	@PostMapping("edit")
	@ResponseBody
	public CustQnAView edit(@RequestBody CustQnA custQna) {
		
		int res = custQnaService.update(custQna);
		CustQnAView qna = custQnaService.get(custQna.getId());
		
		return qna;
	}
	
	@GetMapping("del")
	@ResponseBody
	public List<CustQnAView> del(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			int[] id) {
		
		int res = custQnaService.delete(id);
		List<CustQnAView> list = custQnaService.getList(page, field, query);
		
		return list;
	}
	
}