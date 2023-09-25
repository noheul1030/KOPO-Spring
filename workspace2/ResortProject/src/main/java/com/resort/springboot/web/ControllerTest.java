package com.resort.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ControllerTest {

	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/index_1")
	public String index1() {
		return "index_1";
	}
	@GetMapping("/properties")
	public String properties() {
		return "properties";
	}
	@GetMapping("/propertySingle")
	public String propertySingle() {
		return "property-single";
	}
	@GetMapping("/services")
	public String services() {
		return "services";
	}

	
	@GetMapping("/resortMain")
	public String resortMain() {
		return "resortMain";
	}
	@GetMapping("/signUp")
	public String signUp() {
		return "signUp";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
