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

		@NotEmpty(message = "예약날짜는 필수항목입니다.")
		private LocalDateTime date;
		@NotEmpty(message = "예약금액은 필수항목입니다.")
		private Integer reservationFee;

		// Dto -> Entity
		public Reservation toEntity() {
			Reservation reservation = Reservation.builder().reservationId(reservationId)
					.reservationUser(reservationUser).topSuiteRoom(topSuiteRoom).familyRoom(familyRoom)
					.businessRoom(businessRoom).standardRoom(standardRoom).date(date).reservationFee(reservationFee)
					.build();

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
		private LocalDateTime date;
		private Integer reservationFee;

		// Entity -> Dto
		public Response(Reservation reservation) {
			this.reservationId = reservation.getReservationId();
			this.reservationUser = reservation.getReservationUser();
			this.topSuiteRoom = reservation.getTopSuiteRoom();
			this.familyRoom = reservation.getFamilyRoom();
			this.businessRoom = reservation.getBusinessRoom();
			this.standardRoom = reservation.getStandardRoom();
			this.date = reservation.getDate();
			this.reservationFee = reservation.getReservationFee();
		}
	}
}
