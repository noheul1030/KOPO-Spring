package com.resort.springboot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RoomReservationItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long reservationNumber;
	
	// 회원 ID
	@Column(length = 30, nullable = false)
	private String id;
	
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

}
