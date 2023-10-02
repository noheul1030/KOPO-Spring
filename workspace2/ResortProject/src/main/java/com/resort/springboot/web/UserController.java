package com.resort.springboot.web;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.resort.springboot.dto.UserInformationDto;
import com.resort.springboot.service.UserInformationServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserInformationServiceImpl userService;
	
	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("userDto", new UserInformationDto.Request());
		return "signUp";
	}
	
	// 회원가입
	@PostMapping("/signUp")
	public String signUp(@Valid UserInformationDto.Request userDto, Errors errors, Model model) {

		if (errors.hasErrors()) {
			model.addAttribute("userDto", userDto);

			Map<String, String> validatedResult = userService.validateHandling(errors);
			for (String key : validatedResult.keySet()) {
				model.addAttribute(key, validatedResult.get(key));
			}

			return "signUp";
		}

		userService.userJoin(userDto);

		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/index")
    public ResponseEntity<String> handlePostRequest() {
        // POST 요청 처리 로직
        return ResponseEntity.ok("POST 요청이 처리되었습니다.");
    }
}
