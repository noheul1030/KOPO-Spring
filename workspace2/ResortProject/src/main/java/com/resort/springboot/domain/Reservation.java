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
	private String year;

	@Column
	private String month;

	@Column
	private String day;

	@Column
	private LocalDateTime localDate;
}

// TODO: Reservation Table 정규화 예정
/*
 * 1. Reservation -> Room 으로 연결하는 정규화 방식을 쓸것인지? 
 * 예시) 
 * <Reservation Table> 
 * - (PK)reservation_id / room_id / year / month / day / localDate / user_id
 * <Room Table>
 * - (PK) room_id / room_type
 * 
 * 2. 날짜에 대한 조회를 통해 room 예약 정보를 조회할것인지?
 * 
 */