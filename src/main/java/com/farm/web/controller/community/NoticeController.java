package com.farm.web.controller.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.farm.web.entity.Notice;
import com.farm.web.entity.NoticeView;
import com.farm.web.service.NoticeService;

@Controller("CommunityNoticeController")
@RequestMapping("/community/notice/")
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	@GetMapping("list")
	public String list(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			Model model) {
		List<Notice> list = noticeService.getList(page, field, query);
		model.addAttribute("list", list);
		
		return "community.notice.list";
	}

	@GetMapping("{id}")
	public String detail(@PathVariable("id") int id, Model model) {
		
		NoticeView noticeView = noticeService.getComm(id);
		model.addAttribute("n", noticeView);
		
		
		return "community.notice.detail";
	}
	
}
