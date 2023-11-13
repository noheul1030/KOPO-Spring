package com.resort.springboot.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resort.springboot.domain.Reservation;
import com.resort.springboot.domain.Room;
import com.resort.springboot.domain.SiteUser;
import com.resort.springboot.exception.DataNotFoundException;
import com.resort.springboot.repo.ReservationRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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
	public static Specification<Reservation> search(String search) {
		return new Specification<>() {
            private static final long serialVersionUID = 1L;
            @Override
            public Predicate toPredicate(Root<Reservation> reservation, CriteriaQuery<?> query, CriteriaBuilder cb) {
                query.distinct(true);  // 중복을 제거 
                Join<Reservation, SiteUser> user = reservation.join("user", JoinType.LEFT);
                Join<Reservation, Room> room = reservation.join("room", JoinType.LEFT);

                return cb.or(
                        cb.equal(reservation.get("year"), search),        // year
                        cb.equal(reservation.get("month"), search),      // month
                        cb.equal(reservation.get("day"), search),        // day
                        cb.like(room.get("type"), "%" + search + "%"),    // room.type
                        cb.like(user.get("id"), "%" + search + "%"),      // user.id 
                        cb.like(user.get("name"), "%" + search + "%"),    // user.name 
                        cb.like(user.get("phoneNumber"), "%" + search + "%"),  // user.phoneNumber 
                        cb.like(user.get("email"), "%" + search + "%")    // user.email 
                );
            }
        };
    }

	// 1. list
//	public Page<Reservation> getList(int page, String sort, String search) {
//        if (search != null && !search.isEmpty()) {
//        	Specification<Reservation> spec = search(search);
//        	return this.reservationRepository.findAll(spec, PageRequest.of(page, 10, Sort.by(sorts)));
////            return this.reservationRepository.searchAllColumns(search, PageRequest.of(page, 10));
//        } else {
//            return getSortedList(page, sort);
//        }
//    }

	public Page<Reservation> getList(int page, String sort, String search) {
		List<Sort.Order> sorts = new ArrayList<>();

		if (sort.equals("")) {
			sorts.add(Sort.Order.desc("year"));
			sorts.add(Sort.Order.desc("month"));
			sorts.add(Sort.Order.desc("day"));
			sorts.add(Sort.Order.desc("roomId"));
		} else if (sort.equals("reservationId")) {
			sorts.add(Sort.Order.asc("reservationId"));
		} else if (sort.equals("reservationId,desc")) {
			sorts.add(Sort.Order.desc("reservationId"));
		} else if (sort.equals("year")) {
			sorts.add(Sort.Order.asc("year"));
			sorts.add(Sort.Order.asc("month"));
			sorts.add(Sort.Order.asc("day"));
		} else if (sort.equals("year,desc")) {
			sorts.add(Sort.Order.desc("year"));
			sorts.add(Sort.Order.desc("month"));
			sorts.add(Sort.Order.desc("day"));
		}

		if (search != null && !search.isEmpty()) {
			return this.reservationRepository.findAllByKeyword(search, PageRequest.of(page, 10, Sort.by(sorts)));
		}

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
