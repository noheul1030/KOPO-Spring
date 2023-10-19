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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Entity
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

	// TOP SUITE ROOM
	@Column
	private String topSuiteRoom;

	// FAMILY ROOM
	@Column
	private String familyRoom;

	// BUSINESS ROOM
	@Column
	private String businessRoom;

	// STANDARD ROOM
	@Column
	private String standardRoom;

	@Column
	private String date;

	@Column
	private LocalDateTime localDate;
}
