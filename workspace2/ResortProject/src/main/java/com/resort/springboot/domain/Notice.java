package com.resort.springboot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long noticeId;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String title;
	
	@Column
	private String date;
	
	@Column
	private String content;
	
	@Column 
	private Integer viewcnt;
}
