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

import com.resort.springboot.domain.SiteUser;
import com.resort.springboot.dto.UserDto;
import com.resort.springboot.repo.UserRepository;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application.properties")
public class UserServiceTest {

//@Autowired
//UserService userService;
//
//@Autowired
//    PasswordEncoder passwordEncoder;
//
//
//public User createMember(){
//    UserDto userDto = new UserDto();
//    userDto.setEmail("test@email.com");
//    userDto.setName("홍길동");
//    userDto.setAddress("서울시 마포구 합정동");
//    userDto.setPassword("1234");
//    return User.createUser(userDto,passwordEncoder);
//
//}
//    @Test
//    @DisplayName("회원가입 테스트")
//    public void saveMemberTest(){
//    	User user = createMember();
//    	User savedUser = userService.saveUser(user);
//
//        assertEquals(User.getEmail(), savedUser.getEmail());
//        assertEquals(User.getName(), savedUser.getName());
//        assertEquals(User.getAddress(), savedUser.getAddress());
//        assertEquals(User.getPassword(), savedUser.getPassword());
//        assertEquals(User.getRole(), savedUser.getRole());
//}
//@Test
//    @DisplayName("중복 회원 가입 테스트")
//    public void saveDuplicateMemberTest(){
//	User member1 = createMember();
//	User member2 = createMember();
//	userService.saveUser(member1);
//
//    Throwable e = assertThrows(IllegalStateException.class,() -> {
//        memberService.saveMember(member2);});
//    assertEquals("이미 가입된 회원입니다.",e.getMessage());
//}


}