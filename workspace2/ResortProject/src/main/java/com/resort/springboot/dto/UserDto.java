package com.resort.springboot.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.resort.springboot.domain.Role;
import com.resort.springboot.domain.SiteUser;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserDto {
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	@Getter
	@Setter
	public static class Request{
		
	
		private Long userId;
		
		@Pattern(regexp = "^[가-힣a-zA-Z0-9]{3,20}$", message = "아이디는 3~20자로 한글, 영어 대소문자와 숫자만 허용됩니다.")
		@NotBlank(message = "아이디는 필수 입력 값입니다.")
		@Length(min = 3, max = 20, message = "아이디는 3자 이상, 20자 이하로 입력해주세요.")
		private String id;
	
		@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[A-Za-z\\d@#$%^&+=!]{3,20}$", message = "영어 대소문자, 숫자, 특수 기호(@#$%^&+=!)를 포함하는 3자 이상, 20자 이하의 패턴이어야 합니다.")
		@NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
		@Length(min = 3, max = 20, message = "비밀번호는 3자 이상, 20자 이하로 입력해주세요.")
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
		
		
		private String zipcode; 
    	private String streetAdr;
    	private String detailAdr;
		
		public SiteUser createUser() {
			SiteUser user = SiteUser.builder()
					.userId(userId)
					.id(id)
		    		.password(password)  //암호화처리
		    		.email(email)
		            .name(name)
		            .sex(sex)
		            .phoneNumber(phoneNumber)
		            .role(Role.USER)		            
		         
		            .zipcode(zipcode)
		            .streetAdr(streetAdr)
		            .detailAdr(detailAdr)
		            
		            .build();
		    return user;
		}
	}
	
	@Getter
    public static class Response implements Serializable {		
        
		private final Long userId;
		private final String id;
    	private final String password;
    	private final String email;
    	private final String name;
    	private final String sex;
    	private final String phoneNumber;
        private final Role role;
        
        private String zipcode; 
    	private String streetAdr;
    	private String detailAdr;
        
        // Entity -> Dto
        public Response(SiteUser user) {
        	this.userId = user.getUserId();
            this.id = user.getId();
            this.password = user.getPassword();
            this.email = user.getEmail();
            this.name = user.getName();
            this.sex = user.getSex();
            this.phoneNumber = user.getPhoneNumber();
            this.role = user.getRole();
            
            this.zipcode = user.getZipcode();
            this.streetAdr = user.getStreetAdr();
            this.detailAdr = user.getDetailAdr();
        }
	}
	
}