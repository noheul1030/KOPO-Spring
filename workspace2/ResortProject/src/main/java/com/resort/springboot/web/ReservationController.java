package com.resort.springboot.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.resort.springboot.dto.DateData;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ReservationController {
	@GetMapping(value = "reservationView")
//	@GetMapping("/reservationView")
	public String reservationView() {
		return "reservationView";
	}

//	@RequestMapping(value = "reservationView.do", method = RequestMethod.GET)
	@RequestMapping(value = "reservationView")
	public String calendar(Model model, HttpServletRequest request, DateData dateData) {
		Calendar cal = Calendar.getInstance();
		DateData calendarData;

		if (dateData.getDate().equals("") && dateData.getMonth().equals("")) {
			dateData = new DateData(String.valueOf(cal.get(Calendar.YEAR)), String.valueOf(cal.get(Calendar.MONTH)),
					String.valueOf(cal.get(Calendar.DATE)), null);
		}

		Map<String, Integer> today_info = dateData.today_info(dateData);
		List<DateData> dateList = new ArrayList<DateData>();

		for (int i = 1; i < today_info.get("start"); i++) {
			calendarData = new DateData(null, null, null, null);
			dateList.add(calendarData);
		}

		for (int i = today_info.get("startDay"); i <= today_info.get("endDay"); i++) {
			if (i == today_info.get("today")) {
				calendarData = new DateData(String.valueOf(dateData.getYear()), String.valueOf(dateData.getMonth()),
						String.valueOf(i), "today");
			} else {
				calendarData = new DateData(String.valueOf(dateData.getYear()), String.valueOf(dateData.getMonth()),
						String.valueOf(i), "nomal_date");
			}

			dateList.add(calendarData);
		}

		int index = 7 - dateList.size() % 7;

		if (dateList.size() % 7 != 0) {
			for (int i = 0; i < index; i++) {
				calendarData = new DateData(null, null, null, null);
				dateList.add(calendarData);
			}
		}

		System.out.println(dateList);

		model.addAttribute("dateList", dateList);
		model.addAttribute("today_info", today_info);

		return "reservationView";
	}
}
