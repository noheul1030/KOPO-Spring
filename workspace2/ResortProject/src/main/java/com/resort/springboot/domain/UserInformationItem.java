package com.resort.springboot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserInformationItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long userNumber;
	
	// 회원 ID
	@Column(length = 50, nullable = false, unique = true)
	private String id;
	
	// 회원 비밀번호
	@Column(nullable = false)
	private String passward;
	
	// 이메일
	@Column(nullable = false, unique = true)
	private String email;
	
	// 회원 이름
	@Column(nullable = false)
	private String name;
	
	// 성별
	@Column(nullable = false)
	private String sex;
	
	// 전화번호
	@Column(nullable = false)
	private String phoneNumber;
	
	// 권한
	@Column(nullable = false)
	private String authority;
	
}
