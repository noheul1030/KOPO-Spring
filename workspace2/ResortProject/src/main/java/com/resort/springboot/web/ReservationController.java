package com.resort.springboot.web;

import java.io.IOException;
import java.security.Principal;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

import jakarta.servlet.http.HttpServletResponse;
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

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// CREATE OK
	@GetMapping("/reserveOk")
	public String Ok() {
		return "reserveOk";
	}

	// CREATE
	@GetMapping("reserve_create")
	public String Create(ReservationDto.Request reservationDto, Model model, Principal principal) {
		// 현재 로그인된 유저의 정보를 가져오기 위한 작업
		SiteUser user = this.userService.getUser(principal.getName());
		Reservation reservation = new Reservation();
		reservation.setReservationUser(user);

		model.addAttribute("reservation", reservation);

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
			bindingResult.reject("error.reservation.exists", "해당 날짜에 이미 예약된 ROOM 입니다.");

			return "reserve_create";
		}

	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// READ
	@GetMapping("/reserve_ADMIN_list")
	public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "sort", defaultValue = "") String sort,
			@RequestParam(value = "search", defaultValue = "") String search) {

		Page<Reservation> paging = this.reservationService.getList(page, sort, search);
		model.addAttribute("paging", paging);

		return "/reserve_ADMIN_list";
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// UPDATE
	@GetMapping("reserve_update")
	public String update(Model model, ReservationDto.Request reservationDto) {
		Reservation reserve = reservationService.oneSelectView(reservationDto.getReservationId());
		model.addAttribute("redetail", reserve);

		return "reserve_update";
	}

	@PostMapping("reserve_update")
	public String update(@Valid @ModelAttribute("redetail") ReservationDto.Request reservationDto,
			BindingResult bindingResult, Reservation reservation) {

		if (bindingResult.hasErrors()) {
			return "reserve_update";
		}

		try {

			this.reservationService.update(reservation);

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			if (authentication != null
					&& authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
				return "redirect:/reserve_ADMIN_list"; // ADMIN 페이지로 이동
			} else {
				return "redirect:/reserve_USER_list"; // 일반 사용자 페이지로 이동
			}

		} catch (Exception e) {
			e.printStackTrace();
			bindingResult.reject("error.reservation.exists", "해당 날짜에 이미 예약된 ROOM 입니다.");

			return "reserve_update";
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// DELETE
	@GetMapping(value = "/reserve_delete")
	public void deleteBoard(Model model, ReservationDto.Request reservationDto, HttpServletResponse resp)
			throws IOException {

		// 아이디에 해당하는 예약을 삭제합니다.
		reservationService.deleteId(reservationDto.getReservationId());
		resp.sendRedirect("/reserve_ADMIN_list");
	}

}
