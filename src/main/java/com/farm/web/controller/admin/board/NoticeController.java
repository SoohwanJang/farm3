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

import com.farm.web.entity.Notice;
import com.farm.web.service.NoticeService;

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

	@GetMapping("list")
	public String list(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			Model model) {
		List<Notice> list = noticeService.getList(page, field, query);
		model.addAttribute("list", list);
		
		return "admin.board.notice.list";
	}
	
	@GetMapping("{id}")
	public String detail(@PathVariable("id") int id, Model model) {
		
		Notice notice = noticeService.get(id);
		model.addAttribute("n", notice);
		
		return "admin.board.notice.detail";
	}
	
	
	@GetMapping("reg")
	public String reg() {
		
		return "admin.board.notice.reg";
	}
	
	@PostMapping("reg")
	public String reg(@RequestBody Notice notice) {

		noticeService.insert(notice);
		
		return "redirect:list";
	}
	
	@GetMapping("edit")
	public String edit(int id, Model model) {
		
		Notice notice = noticeService.get(id);
		model.addAttribute("n", notice);
		
		return "admin.board.notice.edit";
	}
	
	@GetMapping("update")
	@ResponseBody
	public List<Notice> edit(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			int id[]) {
		
		noticeService.updatePub(id);
		List<Notice> list = noticeService.getList(page, field, query);
		
		return list;
	}
	
	@PostMapping("edit")
	public String edit(@RequestBody Notice notice) {

		noticeService.update(notice);
		
		return "redirect:list";
	}
	
	@GetMapping("del")
	@ResponseBody
	public List<Notice> del(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			int[] id) {
		
		int res = noticeService.delete(id);
		List<Notice> list = noticeService.getList(page, field, query);
		
//		return null;
		return list;
	}
}