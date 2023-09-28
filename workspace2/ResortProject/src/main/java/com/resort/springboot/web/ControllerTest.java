package com.resort.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerTest {

	// =============
	// 헤더, 푸터
	@GetMapping("/header")
	public String header() {
		return "fragments/header";
	}

	@GetMapping("/footer")
	public String footer() {
		return "fragments/footer";
	}
	// =============

	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	@GetMapping("/location")
	public String location() {
		return "location";
	}

	@GetMapping("/noticeBoard")
	public String noticeBoard() {
		return "noticeBoard";
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
	
//	@GetMapping("/signUp")
//	public String signUp() {
//		return "signUp";
//	}
//
//	@GetMapping("/login")
//	public String login() {
//		return "login";
//	}
}
