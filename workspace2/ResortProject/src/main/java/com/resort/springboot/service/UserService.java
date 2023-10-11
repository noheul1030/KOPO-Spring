package com.resort.springboot.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.resort.springboot.domain.Role;
import com.resort.springboot.domain.SiteUser;
import com.resort.springboot.dto.UserDto;
import com.resort.springboot.exception.DataNotFoundException;
import com.resort.springboot.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public SiteUser saveUser(SiteUser user) {
		validateDuplicateUser(user);

		return userRepository.save(user);
	}

	public void validateDuplicateUser(SiteUser user) {
		SiteUser findEmail = userRepository.findByEmail(user.getEmail());
		if (findEmail != null) {
			throw new IllegalStateException("이미 가입된 이메일입니다.");
		}
		Optional<SiteUser> findId = userRepository.findById(user.getId());
		if (findId != null) {
			throw new IllegalStateException("이미 가입된 아이디입니다.");
		}
	}

	public SiteUser create(Long userId, String id, String password, String email, String name, String sex,
			String phoneNumber, Role role) {

		SiteUser user = new SiteUser();

		user.setUserId(userId);
		user.setId(id);
		user.setPassword(passwordEncoder.encode(password));
		user.setEmail(email);
		user.setName(name);
		user.setSex(sex);
		user.setPhoneNumber(phoneNumber);
		user.setRole(role);
		this.userRepository.save(user);

		return user;
	}

	// 회원가입
	@Transactional
	public void userJoin(UserDto.Request userDto) {

		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		userRepository.save(userDto.createUser());
	}

	
	public SiteUser getUser(String id) {
        Optional<SiteUser> user = this.userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new DataNotFoundException("user not found");
        }
	}

	// 회원가입 -> 중복 체크, 유효성 검사
	@Transactional(readOnly = true)
	public Map<String, String> validateHandling(BindingResult errors) {
		Map<String, String> validatedResult = new HashMap<>();
		for (FieldError error : errors.getFieldErrors()) {
			String validForm = String.format("valid_%s", error.getField());
			validatedResult.put(validForm, error.getDefaultMessage());
		}

		return validatedResult;
	}
}