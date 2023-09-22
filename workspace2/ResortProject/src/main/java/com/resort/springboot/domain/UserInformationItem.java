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
public class UserInformationItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long userNumber;
	
	@Column(length = 30, nullable = false)
	private String id;
	
	@Column(nullable = false)
	private String passward;
	
	@Column(nullable = false)
	private String authority;
	
}
