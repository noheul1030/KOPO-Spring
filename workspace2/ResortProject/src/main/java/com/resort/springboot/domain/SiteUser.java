package com.resort.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class SiteUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Long userId;

	// 1.회원 ID
	@Column(nullable = false, unique = true)
	private String id;

	// 2.회원 비밀번호
	@JsonIgnore
	@Column(nullable = false)
	private String password;

	// 3.이메일
	@Column(nullable = false)
	private String email;

	// 4.회원 이름
	@Column(nullable = false)
	private String name;

	// 5.성별
	@Column(nullable = false)
	private String sex;

	// 6.전화번호
	@Column(nullable = false)
	private String phoneNumber;

	// 7. 권한
	@Enumerated(EnumType.STRING)
	private Role role;

	// 8. 우편번호
	private String zipcode;

	// 9. 도로명주소
	private String streetAdr;

	// 10. 상세주소
	private String detailAdr;

}