package com.resort.springboot.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resort.springboot.domain.Reservation;
import com.resort.springboot.domain.SiteUser;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	// 1. 전체 조회
	Page<Reservation> findAll(Pageable pageable);

	// 2. 한건 조회
	Optional<Reservation> findByReservationId(Long user);

	// 3. 아이디 조회
	Page<Reservation> findByReservationUser(SiteUser siteUser, Pageable pageable);

	// 4. 날짜 조회
	Page<Reservation> findByDate(String date, Pageable pageable);

	// DELETE

	void deleteByReservationId(Long id);
}
