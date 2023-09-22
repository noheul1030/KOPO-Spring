package com.resort.springboot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ResortReservationItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long noticeId;
	
	@Column
	private String id;
	
	@Column
	private String passward;
	
	@Column
	private String title;
	
	@Column
	private String date;
	
	@Column
	private String content;
	
	@Column 
	private Integer viewcnt;
}
