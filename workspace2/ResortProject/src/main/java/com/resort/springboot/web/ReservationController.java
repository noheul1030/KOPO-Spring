package com.resort.springboot.web;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.resort.springboot.domain.Reservation;
import com.resort.springboot.domain.Room;
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

	@GetMapping("/reserveCalendar")
	public String services() {
		return "reserveCalendar";
	}
	
	@GetMapping("/reserve_list")
	public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {

		Page<Reservation> paging = this.reservationService.getList(page);
		model.addAttribute("paging", paging);

		return "/reserve_list";
	}

	// CREATE OK
	@GetMapping("/reserveOk")
	public String Ok() {
		return "reserveOk";
	}

	// CREATE

	@GetMapping("reserve_create")
	public String Create(ReservationDto.Request reservationDto, Model model) {
		model.addAttribute("reservation", reservationDto);

		return "reserve_create";
	}

	@PostMapping("reserve_create")
	public String Create(@Valid @ModelAttribute("reservation") ReservationDto.Request reservationDto,
			BindingResult bindingResult, Principal principal) {

		if (bindingResult.hasErrors()) {
			return "reserve_create";
		}

		try {
			SiteUser user = this.userService.getUser(principal.getName());
			Room room = reservationDto.getRoomId();
			this.reservationService.newReserve(reservationDto.getYear(), reservationDto.getMonth(),
					reservationDto.getDay(), room, user);

			return "redirect:/reserveOk"; // 저장 후 예약OK로 이동
			
		} catch (Exception e) {
			e.printStackTrace();
			bindingResult.reject("error.reservation.exists", "이미 예약된 ROOM 입니다.");
			
			return "reserve_create";
		}

	}

}
