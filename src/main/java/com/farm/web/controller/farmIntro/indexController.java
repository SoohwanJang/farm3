package com.farm.web.controller.farmIntro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("FarmIntroductionController")
@RequestMapping("/farmIntro/")
public class indexController {
	
	@GetMapping("index")
	public String index() {
		
		return "farmIntro.index";

	}
	
}
