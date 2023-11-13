package com.resort.springboot.repo;

import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
	Page<Reservation> findByYearAndMonthAndDay(String year, String month, String day, Pageable pageable);

	// DELETE

	void deleteByReservationId(Long id);

	// Search
	@Query("select cast(reservation.reservationId as string), CONCAT(reservation.year, '-', reservation.month, '-', reservation.day) AS formatted_date, room.type, user.id, user.name, user.phoneNumber ,user.email from Reservation reservation "
			+ "left outer join SiteUser user on reservation.reservationUser=user "
			+ "left outer join Room room on reservation.roomId=room " 
			+ "where "
			+ "   cast(reservation.reservationId as string) like %:search% "
			+ "   or reservation.year like %:search% "
			+ "   or reservation.month like %:search% "
			+ "   or reservation.day like %:search% " 
			+ "   or room.type like %:search% "
			+ "   or user.id like %:search% " 
			+ "   or user.name like %:search% "
			+ "   or user.phoneNumber like %:search% " 
			+ "   or user.email like %:search% ")
	Page<Reservation> findAllByKeyword(@Param("search") String search, Pageable pageable);

//	@Query("SELECT r FROM Reservation r JOIN r.reservationUser ru JOIN r.roomId rm WHERE CONCAT(rm.type, ru.id, ru.name, ru.phoneNumber, ru.email) LIKE :search")
//	Page<Reservation> searchAllColumns(@Param("search") String search, Pageable pageable);

}
