package com.farm.web.controller.admin;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.farm.web.dao.MemberDao;
import com.farm.web.entity.AdminSellerView;
import com.farm.web.entity.Member;
import com.farm.web.entity.SellerApply;
import com.farm.web.service.MemberService;

@Controller
@RequestMapping("/admin/member/")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	// 판매자 리스트 조회
	@GetMapping("seller")
	public String list(
			@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "q", defaultValue = "") String query,
			// 검색 기본 값을 유저 name로 셋팅
			@RequestParam(name = "f", defaultValue = "name") String field, Model model) 
			throws ClassNotFoundException, SQLException {
			
		List<AdminSellerView> list = memberService.getAdminSellerList(page, field, query);
		model.addAttribute("list", list);
		
		return "admin.member.seller";
	}
	
	@GetMapping("pager")
	public List<AdminSellerView> getPageList(
			@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "q", defaultValue = "") String query,
			// 검색 기본 값을 유저 name로 셋팅
			@RequestParam(name = "f", defaultValue = "name") String field, Model model) 
			throws ClassNotFoundException, SQLException {
	
		List<AdminSellerView> list = memberService.getAdminSellerList(page, field, query);
		
		return list;
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	// 입점 신청 세부사항
	@GetMapping("sellerDetail")
	public String getAdminAuthList(int id, Model model) throws ClassNotFoundException, SQLException {
		
		SellerApply sellerApply = memberService.getAdminAuthList(id);
		model.addAttribute("s", sellerApply);	// 판매자목록 → 입점신청정보
		
		System.out.println(id);	// id 확인용
		
		return "admin.member.sellerDetail";
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	// 구매자 리스트 조회
	@GetMapping("member")
	public String list2(
			@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "q", defaultValue = "") String query,
			@RequestParam(name = "f", defaultValue = "name") String field, Model model) 
			throws ClassNotFoundException, SQLException {
	
		List<Member> list2 = memberService.getAdminBuyerList(page, query, field);
		model.addAttribute("list2", list2);
		
		return "admin.member.member";
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	// 회원 삭제 (비활성화)
//	@GetMapping("delete")
//	public String delete(String uid, Model model) {
//		
//		int delete = memberDao.delete(uid);
//		model.addAttribute("del", delete);
//		
//		return "admin.member.seller";
//	}
	
	@PostMapping("update")
	public String update(String uid, Model model) throws ClassNotFoundException, SQLException {
		
		int unabledMember = memberService.unabledMember(uid);
		model.addAttribute("unable", unabledMember);
		
		int enabledMember = memberService.enabledMember(uid);
		model.addAttribute("enable", enabledMember);
		
		return "admin.member.seller";
		
	}
	
	@GetMapping("changeEnabled")
	   @ResponseBody
	   public int deletComment(@RequestParam("sellerId") String sellerId) throws ClassNotFoundException, SQLException {

	      System.out.println(sellerId);
	      
	      return memberService.unabledMember(sellerId);
	   }
	
}
