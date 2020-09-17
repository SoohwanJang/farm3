package com.farm.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/error/")
public class ErrorController {
	
	@GetMapping("default")
	public String defaultError() {
		return "error/default";
	}

	@GetMapping("no-resource")
	public String noResource() {
		return "error/noResource";
	}

	@GetMapping("server-error")
	public String serverError() {
		return "error/server";
	}

}
