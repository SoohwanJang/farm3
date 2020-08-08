package com.farm.web.controller.seller.item;


import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.farm.web.dao.MemberDao;
import com.farm.web.entity.Member;
import com.farm.web.entity.ReviewView2;
import com.farm.web.service.ReviewService;

@Controller("sellerReivewController")
@RequestMapping("/seller/item/review/") // url 경로
public class ReviewController {

	@Autowired
	ReviewService ReivewService;
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("list")
	public String list(@RequestParam(name = "q", defaultValue = "") String query,
			@RequestParam(name = "f", defaultValue = "name") String field,
			@RequestParam(name = "catg", defaultValue = "") String category,
			@RequestParam(name = "p", defaultValue = "1") Integer page,
			Principal principal,
			Model model) {
		
		String uid = principal.getName();
		Member member = memberDao.getByUid(uid);
		int id =member.getId();
		
		
		List<ReviewView2> review = null;
		review = ReivewService.getList2(id, page, field, query);
		model.addAttribute("review", review);

		return "seller/item/review";//리턴할 페이지 경로 -실제보여주는 맵핑 주소
	}
	
	@PostMapping("reg") //답글 등록
	public String reg(String reply) throws IOException { 
		System.out.println(reply);
		
		
//		// upload앞의 상대경로를 알기위해 ServletContext를 사용
//		String path = request.getServletContext().getRealPath("/upload/");
//
//		String uid = principal.getName(); //사용자가 로그인에 사용한 uid
//		System.out.println(id);
//		
//		Review.setWriterId(id); //로그인된 사용자가 글(제목, 내용)을 작성하게 되면 나오게되는 uid
//		
		return "redirect:list"; // url을 표기하는 방법
	}

		

}
