package com.resort.springboot.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Reservation", 
	uniqueConstraints = {
		@UniqueConstraint(
			name = "UniqueReservation", 
			columnNames = { "room_id", "year", "month", "day" }
		) 
	}
)
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long reservationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private SiteUser reservationUser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id", nullable = false)
	private Room roomId;

	@Column(name = "year", nullable = false)
	private String year;

	@Column(name = "month", nullable = false)
	private String month;

	@Column(name = "day", nullable = false)
	private String day;

	@Column
	private LocalDateTime localDate;

}
