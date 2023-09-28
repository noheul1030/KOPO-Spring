package com.resort.springboot.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserInformationDto {

	@NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
	@Length(min = 4, max = 16, message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요.")
	private String password;

	@NotEmpty(message = "이메일은 필수 입력 값입니다.")
	@Email(message = "이메일 형식으로 입력해주세요.")
	private String email;

	@NotBlank(message = "이름은 필수 입력 값입니다.")
	private String name;

	@NotBlank(message = "성별을 입력해주세요.")
	private String sex;

	@NotBlank(message = "연락처를 입력해주세요.")
	private String phoneNumber;

//    @NotEmpty(message = "주소는 필수 입력 값입니다.")
//    private String address;

	@Builder
	public UserInformationDto(String password, String email, String name, String sex, String phoneNumber) {
		this.password = password;
		this.email = email;
		this.name = name;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
	}

}
