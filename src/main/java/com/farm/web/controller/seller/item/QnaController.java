package com.farm.web.controller.seller.item;

import java.io.IOException;
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
import com.farm.web.entity.Item;
import com.farm.web.entity.ItemQnA;
import com.farm.web.entity.ItemQnAListView;
import com.farm.web.entity.Member;
import com.farm.web.service.QnaService;


@Controller("sellerQnaController")
@RequestMapping("/seller/item/qna/")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("list")
	public String list(
		@RequestParam(name = "p", defaultValue = "1") Integer page, 
		@RequestParam(name = "q", defaultValue = "") String query,
		@RequestParam(name = "f", defaultValue = "iName") String field,
		Principal principal,
		Model model) {
		
		String uid = principal.getName();
		Member member = memberDao.getByUid(uid);
		int id =member.getId();

		List<ItemQnAListView> qList = qnaService.getQnAList(id, page, query, field);
		List<Item> iList = qnaService.getItemList(id);
		model.addAttribute("iList", iList);
		model.addAttribute("qList", qList);
		
		
		return "seller/item/qna";
	}
	
	@PostMapping("list")
	public String list2(
			HttpServletRequest request,
			Principal principal,
			Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String query = request.getParameter("fs");
		int page = 1;
		String field = "iName";
		String uid = principal.getName();
		Member member = memberDao.getByUid(uid);
		int id =member.getId();
		
		List<ItemQnAListView> qList = qnaService.getQnAList(id, page, query, field);
		List<Item> iList = qnaService.getItemList(id);
		model.addAttribute("q",query);
		model.addAttribute("qList",qList);
		model.addAttribute("iList", iList);
		
		return "seller/item/qna";
	}
	
	
	@GetMapping("{dtlNum}")
	public String detail(@PathVariable("dtlNum") int dtlNum, Model model) {
		ItemQnA itemQna = qnaService.getItemQnA(dtlNum);
		
		model.addAttribute("i", itemQna);
		
		return "seller/item/detail";
	}
	
	@GetMapping("answer")
	public String answer(
			Model model,
			HttpServletRequest request) {
		String dtlNum = request.getParameter("dtlNum");
		model.addAttribute("qnaId", dtlNum);
		return "seller/item/answer";
	}
	
	@PostMapping("answer2")
	public String answer2(
			HttpServletRequest request, 
			Principal principal) throws IOException {

	    int result = 0;
	    
	    String data = request.getParameter("ans-content");
	    
//	    itemQnA의 id
	    int id = Integer.parseInt(request.getParameter("qnaId"));
	    result = qnaService.insertAnswer(id,data);
		
	    
	    if(result == 1)
	    	return "redirect:list";
	    else
	    	return "error";
	}
	

}

