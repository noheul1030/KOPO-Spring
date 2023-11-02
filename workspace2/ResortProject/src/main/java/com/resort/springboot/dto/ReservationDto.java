package com.resort.springboot.dto;

import java.time.LocalDateTime;

import com.resort.springboot.domain.Reservation;
import com.resort.springboot.domain.Room;
import com.resort.springboot.domain.SiteUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ReservationDto {

	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	@Getter
	@Setter
	public static class Request {
		private Long reservationId;
		private SiteUser reservationUser;
		private Room roomId;
		
		private String year;
		private String month;
		private String day;
		private LocalDateTime localDate;


		// Dto -> Entity
		public Reservation toEntity() {
			Reservation reservation = Reservation.builder().reservationId(reservationId).roomId(roomId)
					.reservationUser(reservationUser).localDate(localDate).year(year).month(month).day(day).build();

			return reservation;
		}
	}

	@Getter
	public static class Response {
		private Long reservationId;
		private SiteUser reservationUser;
		private Room roomId;
		
		private String year;
		private String month;
		private String day;
		private LocalDateTime localDate;
		
		// Entity -> Dto
		public Response(Reservation reservation) {
			this.reservationId = reservation.getReservationId();
			this.reservationUser = reservation.getReservationUser();
			this.roomId = reservation.getRoomId();
			this.year = reservation.getYear();
			this.month = reservation.getMonth();
			this.day = reservation.getDay();
			this.localDate = reservation.getLocalDate();
		}
	}
}
