package com.farm.web.controller.admin;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.farm.web.dao.MemberDao;

@Controller("adminIndexController")
@RequestMapping("/admin/")	// 관리자 메인 홈 컨트롤러
public class IndexController {
	
	@Autowired
	MemberDao memberDao;
	
	@GetMapping("index")
	public String getCountBuyer(Model model) throws ClassNotFoundException, SQLException {
		
		// 총 회원 수
		int totalMember = memberDao.getCountTotalMember();
		model.addAttribute("ct", totalMember);
		
		// 총 구매자 수
		int totalBuyer = memberDao.getCountBuyer();
		model.addAttribute("cb", totalBuyer);

		// 총 판매자 수
		int totalSeller = memberDao.getCountSeller();
		model.addAttribute("cs", totalSeller);
		
		return "admin.index";
	}
	
}
