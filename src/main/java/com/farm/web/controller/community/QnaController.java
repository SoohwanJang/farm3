package com.farm.web.controller.community;

import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

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

import com.farm.web.entity.CustQnA;
import com.farm.web.entity.CustQnAView;
import com.farm.web.service.CustQnAService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller("CommunityQnaController")
@RequestMapping("/community/qna/")
public class QnaController {

	@Autowired
	private CustQnAService custQnaService;

	@GetMapping("list")
	public String list(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query, Model model) {

		List<CustQnAView> list = custQnaService.getList(page, field, query);
		model.addAttribute("list", list);

		return "community.qna.list";
	}

	@GetMapping("{id}")
	public String detail(@PathVariable("id") int id, Model model) {

		CustQnAView custQnaView = custQnaService.get(id);
		model.addAttribute("q", custQnaView);

		return "community.qna.detail";
	}

	@GetMapping("reg")
	public String reg() {

		return "community.qna.reg";
	}

	@PostMapping("reg")
	public String reg(HttpServletRequest request,Principal principal) throws IOException {

//		String uid = principal.getName(); //로그인 한 uid를 받아오는 security 기능(principal.getName())
		String uid = "seller";
		// custQnaService.insert(custQnAview);

		InputStream is = request.getInputStream(); //보내는 내용을 is에 담음
		Scanner scan = new Scanner(is, "UTF-8"); //scanner로 읽고
		String json = scan.nextLine(); //읽은 부분 json에 담고
		Gson gson = new GsonBuilder().create();

		CustQnA cqa = gson.fromJson(json, CustQnA.class); // gson이 javascript에서 ajax방식을 통해 보낸 json을  CustQnA 엔티티 형식으로 알아서 풀어서 담아라
		
		System.out.println("컨트롤러: "+ cqa);
		custQnaService.insertss(cqa,uid);

		return "redirect:list";
	}

}
