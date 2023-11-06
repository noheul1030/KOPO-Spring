package com.resort.springboot.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resort.springboot.domain.Reservation;
import com.resort.springboot.domain.Room;
import com.resort.springboot.domain.SiteUser;
import com.resort.springboot.exception.DataNotFoundException;
import com.resort.springboot.repo.ReservationRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class ReservationService {

	private final ReservationRepository reservationRepository;

	public Reservation getReservation(Long id) {
		Optional<Reservation> reserve = this.reservationRepository.findByReservationId(id);

		if (reserve.isPresent()) {
			return reserve.get();
		} else {
			throw new DataNotFoundException("해당 예약이 없습니다.");
		}
	}

	/* CREATE */
	public void newReserve(String year, String month, String day, Room room, SiteUser user) {

		Reservation reserve = new Reservation();

		reserve.setReservationUser(user);
		reserve.setRoomId(room);
		reserve.setYear(year);
		reserve.setMonth(month);
		reserve.setDay(day);
		reserve.setLocalDate(LocalDateTime.now());

		this.reservationRepository.save(reserve);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/* READ */

	// 1. list
	public Page<Reservation> getList(int page) {
		List<Sort.Order> sorts = new ArrayList<>();
		
		sorts.add(Sort.Order.desc("year"));
		sorts.add(Sort.Order.desc("month"));
		sorts.add(Sort.Order.desc("day"));
		sorts.add(Sort.Order.desc("roomId"));
		
		PageRequest pageable = PageRequest.of(page, 10, Sort.by(sorts)); // 페이지 번호 0부터 시작

		return this.reservationRepository.findAll(pageable);
	}

	// 2. 한건 조회
	public Reservation oneSelectView(Long id) {

		return this.reservationRepository.findByReservationId(id).orElse(null);
	}

	// 3. 아이디로 검색
	public Page<Reservation> getUser(SiteUser user, int page) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("reservationId"));
		PageRequest pageable = PageRequest.of(page, 10, Sort.by(sorts)); // 페이지 번호 0부터 시작

		return this.reservationRepository.findByReservationUser(user, pageable);
	}

	// 4. 날짜로 검색
	public Page<Reservation> getDate(String year, String month, String day, int page) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("reservationId"));
		PageRequest pageable = PageRequest.of(page, 10, Sort.by(sorts)); // 페이지 번호 0부터 시작

		return this.reservationRepository.findByYearAndMonthAndDay(year, month, day, pageable);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/* UPDATE */
	
	public void update(Reservation reserve) {
		Reservation reserve2 = reservationRepository.findByReservationId(reserve.getReservationId()).get();
		// 가져온 글에 수정한 내용을 세팅한다.
		reserve2.setRoomId(reserve.getRoomId());
		reserve2.setYear(reserve.getYear());
		reserve2.setMonth(reserve.getMonth());
		reserve2.setDay(reserve.getDay());

		// DB에 저장
		reservationRepository.save(reserve2);
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/* DELETE */

	public void deleteId(Long id) {
		this.reservationRepository.deleteByReservationId(id);
	}
}
