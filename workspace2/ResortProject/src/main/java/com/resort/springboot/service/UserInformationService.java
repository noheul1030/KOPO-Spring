package com.resort.springboot.service;

import com.resort.springboot.domain.UserInformationItem;

public interface UserInformationService {

	public UserInformationItem saveUser(UserInformationItem member);
	
	public void validateDuplicateUser(UserInformationItem member);
}
