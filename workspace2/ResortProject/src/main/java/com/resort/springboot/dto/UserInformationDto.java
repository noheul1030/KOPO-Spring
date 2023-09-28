package com.resort.springboot.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.resort.springboot.domain.MemberRole;
import com.resort.springboot.domain.UserInformationItem;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class UserInformationDto {
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	@Getter
	@Setter
	public static class Request{
		
	
		private Long id;
	
		@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[A-Za-z\\d@#$%^&+=!]{8,20}$", message = "비밀번호는 8~20자로 영어 대소문자, 숫자, @#$%^&+=!만 허용됩니다.")
		@NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
		@Length(min = 4, max = 16, message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요.")
		private String password;
	
		@Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "이메일 형식이 올바르지 않습니다.")
		@NotEmpty(message = "이메일은 필수 입력 값입니다.")
		@Email(message = "이메일 형식으로 입력해주세요.")
		private String email;
	
		@Pattern(regexp = "^[가-힣a-zA-Z]{2,30}$", message = "한글 또는 영어 대소문자로 이루어진 이름을 입력하세요.")
		@NotBlank(message = "이름은 필수 입력 값입니다.")
		private String name;
	
		@NotBlank(message = "성별을 입력해주세요.")
		private String sex;
	
		@Pattern(regexp = "^\\d{11,11}$", message = "전화번호는 숫자 11자리만 허용됩니다.")
		@NotBlank(message = "연락처를 입력해주세요.")
		private String phoneNumber;
	
	//    @NotEmpty(message = "주소는 필수 입력 값입니다.")
	//    private String address;
	
		
		public UserInformationItem createUser() {
			UserInformationItem member = UserInformationItem.builder()
		    		.password(password)  //암호화처리
		    		.email(email)
		            .name(name)
		            .sex(sex)
		            .phoneNumber(phoneNumber)
		            .role(MemberRole.USER)
		            .build();
		    return member;
		}
	}
	
	@Getter
    public static class Response implements Serializable {		
        
        private final Long id;
    	private final String password;
    	private final String email;
    	private final String name;
    	private final String sex;
    	private final String phoneNumber;
        private final MemberRole role;
        
        // Entity -> Dto
        public Response(UserInformationItem user) {
            this.id = user.getId();
            this.password = user.getPassword();
            this.email = user.getEmail();
            this.name = user.getName();
            this.sex = user.getSex();
            this.phoneNumber = user.getPhoneNumber();
            this.role = user.getRole();
        }
	}
	
	
	
//	@Builder
//	public UserInformationDto(String password, String email, String name, String sex, String phoneNumber) {
//		this.password = password;
//		this.email = email;
//		this.name = name;
//		this.sex = sex;
//		this.phoneNumber = phoneNumber;
//	}

}
