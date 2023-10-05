package com.resort.springboot.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.resort.springboot.dto.UserDto;
import com.resort.springboot.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserService userService;
	
	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("userDto", new UserDto.Request());
		return "signUp";
	}
	
	// 회원가입
	@PostMapping("signUp")
	public String signUp(@Valid UserDto.Request userDto, Errors errors, Model model) {

		if (errors.hasErrors()) {
			model.addAttribute("userDto", userDto);

			Map<String, String> validatedResult = userService.validateHandling(errors);
			for (String key : validatedResult.keySet()) {
				model.addAttribute(key, validatedResult.get(key));
			}

			return "signUp";
		}
		
		userService.userJoin(userDto);

		return "signUpOk";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	
	
	
}