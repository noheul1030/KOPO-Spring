package com.resort.springboot.dto;

import java.time.LocalDateTime;

import com.resort.springboot.domain.Reservation;
import com.resort.springboot.domain.SiteUser;

import jakarta.validation.constraints.NotEmpty;
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

		private String topSuiteRoom;
		private String familyRoom;
		private String businessRoom;
		private String standardRoom;
		private String year;
		private String month;
		private String day;
		private LocalDateTime localDate;


		// Dto -> Entity
		public Reservation toEntity() {
			Reservation reservation = Reservation.builder().reservationId(reservationId)
					.reservationUser(reservationUser).topSuiteRoom(topSuiteRoom).familyRoom(familyRoom)
					.businessRoom(businessRoom).standardRoom(standardRoom).localDate(localDate).year(year).month(month).day(day).build();

			return reservation;
		}
	}

	@Getter
	public static class Response {
		private Long reservationId;
		private SiteUser reservationUser;
		private String topSuiteRoom;
		private String familyRoom;
		private String businessRoom;
		private String standardRoom;
		private String year;
		private String month;
		private String day;
		private LocalDateTime localDate;
		// Entity -> Dto
		public Response(Reservation reservation) {
			this.reservationId = reservation.getReservationId();
			this.reservationUser = reservation.getReservationUser();
			this.topSuiteRoom = reservation.getTopSuiteRoom();
			this.familyRoom = reservation.getFamilyRoom();
			this.businessRoom = reservation.getBusinessRoom();
			this.standardRoom = reservation.getStandardRoom();
			this.year = reservation.getYear();
			this.month = reservation.getMonth();
			this.day = reservation.getDay();
			this.localDate = reservation.getLocalDate();
		}
	}
}
