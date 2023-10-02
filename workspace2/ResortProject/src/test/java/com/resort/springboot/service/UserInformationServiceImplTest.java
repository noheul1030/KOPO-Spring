package com.resort.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import com.resort.springboot.domain.MemberRole;
import com.resort.springboot.domain.UserInformationItem;
import com.resort.springboot.dto.UserInformationDto;
import com.resort.springboot.repo.UserInformationRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
@TestPropertySource(locations = "classpath:/application.properties")
@DirtiesContext
class UserInformationServiceImplTest {
	
	@Autowired
	UserInformationServiceImpl userinformationServiceImpl;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserInformationRepository userRepository;

	public UserInformationItem create() {

		UserInformationItem user = new UserInformationItem();
		
		user.setPassword(passwordEncoder.encode("123123123123"));
		user.setEmail("test@email.com");
		user.setName("테스트");
		user.setSex("남성");
		user.setPhoneNumber("01031769140");
		user.setRole(MemberRole.ADMIN);
		this.userRepository.save(user);

		return user;
	}
	
	@Test
	@Transactional
	@DisplayName("회원가입")
	public void userJoin(UserInformationDto.Request userDto) {

		UserInformationItem user = create();
		UserInformationItem saveUser = userinformationServiceImpl.saveUser(user);
		
		assertEquals(user.getEmail(), saveUser.getEmail());

		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		userRepository.save(userDto.createUser());
	}

}
