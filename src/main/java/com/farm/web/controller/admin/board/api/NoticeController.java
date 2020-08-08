package com.farm.web.controller.admin.board.api;

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
import org.springframework.web.bind.annotation.RestController;

import com.farm.web.entity.Notice;
import com.farm.web.service.NoticeService;

@RestController("apiNoticeController")
@RequestMapping("/admin/board/notice/api")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

	@GetMapping("list")
	public List<Notice> list(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query) {
		List<Notice> list = noticeService.getList(page, field, query);
		
		return list;
	}
}