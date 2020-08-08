package com.farm.web.controller.admin.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farm.web.entity.CategoryCountView;
import com.farm.web.entity.ItemView;
import com.farm.web.service.CategoryService;
import com.farm.web.service.ItemService;

@RestController("apiItemController")
@RequestMapping("/admin/item/api")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("list")
	public List<ItemView> list(@RequestParam(name = "p", defaultValue="1") int page,
							@RequestParam(name = "q",defaultValue="") String query,
							@RequestParam(name = "f",defaultValue="name") String field,
							@RequestParam(name = "c",defaultValue="") String catg){
		
		List<ItemView> list = itemService.getList(page,query,field,catg);
		
		return list;		
	}
	
	@GetMapping("del")
	public int del(int[] srs){
							//selectRows 
			
		int check = itemService.delList(srs);
		
		return check;
	}
	
}
