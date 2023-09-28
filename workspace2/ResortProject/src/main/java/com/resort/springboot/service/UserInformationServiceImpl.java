package com.resort.springboot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.resort.springboot.domain.MemberRole;
import com.resort.springboot.domain.UserInformationItem;
import com.resort.springboot.dto.UserInformationDto;
import com.resort.springboot.repo.UserInformationRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class UserInformationServiceImpl implements UserInformationService {
	private final UserInformationRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public UserInformationItem saveUser(UserInformationItem member) {
		validateDuplicateUser(member);

		return userRepository.save(member);
	}

	@Override
	public void validateDuplicateUser(UserInformationItem member) {
		UserInformationItem findUser = userRepository.findByEmail(member.getEmail());
		if (findUser != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}
	
	public UserInformationItem create(Long id, String password, String email, String name, String sex,
			String phoneNumber, MemberRole role) {

		UserInformationItem user = new UserInformationItem();
		
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
	public void userJoin(UserInformationDto.Request userDto) {

		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		userRepository.save(userDto.createUser());
	}

	// 회원가입 -> 중복 체크, 유효성 검사
	@Transactional(readOnly = true)
	public Map<String, String> validateHandling(Errors errors) {
		Map<String, String> validatedResult = new HashMap<>();
		for (FieldError error : errors.getFieldErrors()) {
			String validForm = String.format("valid_%s", error.getField());
			validatedResult.put(validForm, error.getDefaultMessage());
		}

		return validatedResult;
	}
}
