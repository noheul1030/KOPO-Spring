package com.resort.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ControllerTest {

	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	@GetMapping("/index")
	public String index() {
		return "index";
	}
}
