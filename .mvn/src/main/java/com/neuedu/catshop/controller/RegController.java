package com.neuedu.catshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegController {

	@GetMapping("/admin/reg")
	public String login() {

		return "reg";
	}
	
	
	
}
