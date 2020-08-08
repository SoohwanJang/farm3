package com.farm.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.farm.web.entity.CategoryCountView;
import com.farm.web.entity.ItemView;
import com.farm.web.service.CategoryService;
import com.farm.web.service.ItemService;

@Controller("adminItemController")
@RequestMapping("/admin/item/")
public class ItemController {
	@Autowired
	ItemService itemService;
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("list")
	public String list(@RequestParam(name = "p", defaultValue="1") int page,
			@RequestParam(name = "q",defaultValue="") String query,
			@RequestParam(name = "f",defaultValue="name") String field,
			@RequestParam(name = "c",defaultValue="") String catg,
			Model model) {
		
		List<CategoryCountView> ccv = categoryService.getCountByCategory();
		List<ItemView> list = itemService.getList(1, query, field, catg);
		int count = itemService.getCount(query, field, catg);

		model.addAttribute("ccv",ccv);
		model.addAttribute("list",list);
		model.addAttribute("count",count);
		
		return "admin.item.list";
	}
	
}
