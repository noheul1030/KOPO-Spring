package com.resort.springboot.web;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.resort.springboot.domain.SiteUser;
import com.resort.springboot.dto.ReservationDto;
import com.resort.springboot.service.ReservationService;
import com.resort.springboot.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ReservationController {
	private final ReservationService reservationService;
	private final UserService userService;

	// CREATE OK
	@GetMapping("/reservationOk")
	public String Ok() {
		return "reservationOk";
	}

	// CREATE

	@GetMapping("reservationView")
	public String Create(ReservationDto.Request reservationDto, Model model) {
		model.addAttribute("reservation", reservationDto);

		return "reservationView";
	}

	@PostMapping("reservationView")
	public String Create(@Valid @ModelAttribute("reservation") ReservationDto.Request reservationDto,
			BindingResult bindingResult, Principal principal) {

		if (bindingResult.hasErrors()) {
			return "reservationView";
		}

		SiteUser user = this.userService.getUser(principal.getName());
		this.reservationService.newReserve(reservationDto.getYear(), reservationDto.getMonth(), reservationDto.getDay(),
				reservationDto.getTopSuiteRoom(), user);

		return "redirect:/reservationOk"; // 저장 후 예약OK로 이동
	}

}
