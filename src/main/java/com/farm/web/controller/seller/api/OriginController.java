package com.farm.web.controller.seller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farm.web.entity.Origin;
import com.farm.web.service.OriginService;

@RestController("apiOriginController")
@RequestMapping("/api/seller/origin/")
public class OriginController {
	
	@Autowired
	OriginService originService;
	
	@GetMapping("list")
	public List<Origin> list(@RequestParam(name = "pid", defaultValue = "0") int pid){
		
		List<Origin> list = originService.getApiList(pid);
		
		return list;		
	}
	

	
}
