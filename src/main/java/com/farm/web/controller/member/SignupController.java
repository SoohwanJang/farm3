package com.farm.web.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.farm.web.entity.Member;
import com.farm.web.service.MemberService;


@Controller
@RequestMapping("/member/")
public class SignupController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("signup")
	public String signup() {
		
		return "member.signup";
	}
	
	@PostMapping("signup")
	public String signup(@RequestBody Member member) {
		
		memberService.insert(member);
		
		return "redirect:/index";
	
	}
	
	@PostMapping("checkId")
	@ResponseBody
	public int checkId(@RequestBody Member member) {
		
		int result = memberService.selectId(member);
		
		return result;
	
	}
	
	@PostMapping("checkEmail")
	@ResponseBody
	public int checkEmail(@RequestBody Member member) {
		
		int result = memberService.selectEmail(member);
		
		return result;
	
	}

}
