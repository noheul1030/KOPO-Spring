package com.resort.springboot.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resort.springboot.domain.Reservation;
import com.resort.springboot.domain.SiteUser;
import com.resort.springboot.repo.ReservationRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class ReservationService {
	private final ReservationRepository reservationRepository;

	/* CREATE */
	public void newReserve(String year, String month, String day, String room, SiteUser user) {

		Reservation reserve = new Reservation();

		reserve.setReservationUser(user);
		reserve.setDate(year + month + day);
		reserve.setLocalDate(LocalDateTime.now());

		if (room.equals("topSuiteRoom")) {
			reserve.setTopSuiteRoom("O");
		} else if (room.equals("familyRoom")) {
			reserve.setFamilyRoom("O");
		} else if (room.equals("businessRoom")) {
			reserve.setBusinessRoom("O");
		} else if (room.equals("standardRoom")) {
			reserve.setStandardRoom("O");
		}

		this.reservationRepository.save(reserve);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/* READ */

	// 1. list
	public Page<Reservation> getList(int page) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("reservationId"));
		PageRequest pageable = PageRequest.of(page, 10, Sort.by(sorts)); // 페이지 번호 0부터 시작

		return this.reservationRepository.findAll(pageable);
	}

	// 2. 한건 조회
	public Reservation getReservation(Long id) {

		return this.reservationRepository.findByReservationId(id).orElse(null);

//		Optional<Reservation> reserve = this.reservationRepository.findByReservationId(id);
//
//		if (reserve.isPresent()) {
//			return reserve.get();
//		} else {
//			throw new DataNotFoundException("해당 예약이 없습니다.");
//		}
	}

	// 3. 아이디로 검색
	public Page<Reservation> getUser(SiteUser user, int page) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("reservationId"));
		PageRequest pageable = PageRequest.of(page, 10, Sort.by(sorts)); // 페이지 번호 0부터 시작

		return this.reservationRepository.findBySiteUser(user, pageable);
	}

	// 4. 날짜로 검색
	public Page<Reservation> getDate(String date, int page) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("reservationId"));
		PageRequest pageable = PageRequest.of(page, 10, Sort.by(sorts)); // 페이지 번호 0부터 시작

		return this.reservationRepository.findByDate(date, pageable);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/* DELETE */

	public void deleteId(Long id) {
		this.reservationRepository.deleteByReservationId(id);
	}

//	public Map<String, Integer> today_info(DateData dateData) {
//		Map<String, Integer> today_Data = new HashMap<String, Integer>();
//		Calendar cal = Calendar.getInstance();
//		cal.set(Integer.parseInt(dateData.getYear()), Integer.parseInt(dateData.getMonth()), 1);
//
//		int startDay = cal.getMinimum(java.util.Calendar.DATE);
//		int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
//		int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
//
//		Calendar todayCal = Calendar.getInstance();
//		SimpleDateFormat ysdf = new SimpleDateFormat("yyyy");
//		SimpleDateFormat msdf = new SimpleDateFormat("M");
//
//		int today_year = Integer.parseInt(ysdf.format(todayCal.getTime()));
//		int today_month = Integer.parseInt(msdf.format(todayCal.getTime()));
//
//		int search_year = Integer.parseInt(dateData.getYear());
//		int search_month = Integer.parseInt(dateData.getMonth()) + 1;
//
//		int today = -1;
//		if (today_year == search_year && today_month == search_month) {
//			SimpleDateFormat dsdf = new SimpleDateFormat("dd");
//			today = Integer.parseInt(dsdf.format(todayCal.getTime()));
//		}
//
//		search_month = search_month - 1;
//
//		Map<String, Integer> before_after_calendar = before_after_calendar(search_year, search_month);
//
//		System.out.println("search_month : " + search_month);
//
//		today_Data.put("start", start);
//		today_Data.put("startDay", startDay);
//		today_Data.put("endDay", endDay);
//		today_Data.put("today", today);
//		today_Data.put("search_year", search_year);
//		today_Data.put("search_month", search_month);
//		today_Data.put("befor_year", before_after_calendar.get("before_year"));
//		today_Data.put("before_month", before_after_calendar.get("before_month"));
//		today_Data.put("after_year", before_after_calendar.get("after_year"));
//		today_Data.put("after_month", before_after_calendar.get("after_month"));
//
//		return today_Data;
//	}
//
//	private Map<String, Integer> before_after_calendar(int search_year, int search_month) {
//		Map<String, Integer> before_after_data = new HashMap<String, Integer>();
//
//		int before_year = search_year;
//		int before_month = search_month - 1;
//		int after_year = search_year;
//		int after_month = search_month + 1;
//
//		if (before_month < 0) {
//			before_month = 11;
//			before_year = search_year - 1;
//		}
//
//		if (after_month > 11) {
//			after_month = 1;
//			after_year = search_year + 1;
//		}
//
//		before_after_data.put("before_year", before_year);
//		before_after_data.put("before_month", before_month);
//		before_after_data.put("after_year", after_year);
//		before_after_data.put("after_month", after_month);
//
//		return before_after_data;
//	}

}
