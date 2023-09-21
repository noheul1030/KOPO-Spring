package com.resort.stringboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ControllerTest {

//	// Test 입력
//	@RequestMapping(value = "/Test")
//	public ResponseEntity<String> insertTest(String str) {
//
//		return ResponseEntity.ok(str);
//	}
	
	@GetMapping("/main")
	public String write() {
		return "main";
	}
}
