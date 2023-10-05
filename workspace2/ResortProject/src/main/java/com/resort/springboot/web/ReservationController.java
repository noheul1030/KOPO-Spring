package com.resort.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {
	@GetMapping("/reservationView")
	public String reservationView() {
		return "reservationView";
	}
}
