//package com.resort.springboot.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.resort.springboot.domain.UserInformationItem;
//import com.resort.springboot.dto.UserInformationDto;
//import com.resort.springboot.service.UserInformationService;
//
//@Transactional
//public class UserServiceTest {
//	@Autowired
//	UserInformationService memberService;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    public UserInformationItem createMember() {
//    	UserInformationDto memberFormDto = UserInformationDto.builder()
//    			.password("1111")
//                .email("test@email.com")
//                .name("테스트")
//                .sex("여성")
//                .phoneNumber("010-0000-0000")
//                .build();
//        return UserInformationItem.createMember(memberFormDto, passwordEncoder);
//    }
//
//    @Test
//    @DisplayName("회원가입 테스트")
//    public void saveMemberTest() {
//    	UserInformationItem member = createMember();
//    	UserInformationItem savedMember = memberService.saveMember(member);
//
//        assertEquals(member.getEmail(), savedMember.getEmail());
//    }
//}