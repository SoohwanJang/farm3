package com.farm.web.controller.member;

import java.util.UUID;

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
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("login")
	public String login() {
		
		return "member.login";
	}
	
	@GetMapping("popup")
	public String popup() {
		
		return "member/popup";
	}
	
	@PostMapping("idSearch")
	@ResponseBody
	public Member idsaarch(@RequestBody Member member) {
		
		member = memberService.getId(member);
		
		return member;
	}
	
	@PostMapping("pwdSearch")
	@ResponseBody
	public Member pwdsaarch(@RequestBody Member member) {
		
		String uuid = "";
		for (int i = 0; i < 5; i++) {
			uuid = UUID.randomUUID().toString().replaceAll("-", "");
			// -를 제거해 주었다.
			uuid = uuid.substring(0, 10);
			//uuid를 앞에서부터 10자리 잘라줌.
		}
		
		member.setPwd(uuid);
		
		return member;
	}


	@PostMapping("updatePwd")
	public Member updatePwd(@RequestBody Member member) {
		memberService.updatePwd(member);
		return member;
	}

}
