package com.resort.springboot.web;

import java.security.Principal;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.resort.springboot.domain.SiteUser;
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
	public String signUp(@Valid @ModelAttribute("userDto") UserDto.Request userDto, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("userDto", userDto);

			Map<String, String> validatedResult = userService.validateHandling(bindingResult);
			for (String key : validatedResult.keySet()) {
				model.addAttribute(key, validatedResult.get(key));
			}

			return "signUp";
		}

		try {
			userService.userJoin(userDto);

		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.rejectValue("id", "error.userDto.id", "이미 등록된 사용자입니다.");

			return "signUp";

		} catch (Exception e) {
			e.printStackTrace();
			bindingResult.reject("signup Failed", e.getMessage());
			return "signUp";
		}

		return "signUpOk";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/mypage")
	public String mypage(Model model, Principal principal) {
		SiteUser useritem = this.userService.getUser(principal.getName());
		model.addAttribute("mypage", useritem);
		
		return "mypage";
	}

	@GetMapping("/user_Update")
	public String userUpdate(Model model, SiteUser user) {
		SiteUser useritem = userService.oneSelectView(user.getUserId());
		model.addAttribute("userUpdate", useritem);

		return "user_Update";
	}

	@PostMapping("/user_Update")
	public String userUpdate(@Valid @ModelAttribute("userUpdate") UserDto.Request userDto, BindingResult bindingResult,
			Model model, SiteUser user) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("userUpdate", userDto);

			Map<String, String> validatedResult = userService.validateHandling(bindingResult);
			for (String key : validatedResult.keySet()) {
				model.addAttribute(key, validatedResult.get(key));
			}

			return "user_Update";
		}
		
		
		SiteUser useritem = userService.oneSelectView(user.getUserId());
		model.addAttribute("userUpdate", useritem);
		
		this.userService.update(user);
		
		return "redirect:/";
	}

}