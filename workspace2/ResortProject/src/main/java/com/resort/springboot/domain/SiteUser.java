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
	@Column(nullable = false, unique = true)
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
	
//	// 7.권한
//	@Column(nullable = false)
//	private String authority;
	
	@Enumerated(EnumType.STRING)
    private Role role;

	
//	@Builder
//	public UserInformationItem(String password, String email, String name, String sex,
//			String phoneNumber, MemberRole role) {
//		this.password = password;
//		this.email = email;
//		this.name = name;
//		this.sex = sex;
//		this.phoneNumber = phoneNumber;
//		this.role = role;
//	}
//	
//	public static UserInformationItem createMember(UserInformationDto dto, PasswordEncoder passwordEncoder) {
//		UserInformationItem member = UserInformationItem.builder()
//        		.password(passwordEncoder.encode(dto.getPassword()))  //암호화처리
//        		.email(dto.getEmail())
//                .name(dto.getName())
//                .sex(dto.getSex())
//                .phoneNumber(dto.getPhoneNumber())
//                .role(MemberRole.USER)
//                .build();
//        return member;
//    }
}