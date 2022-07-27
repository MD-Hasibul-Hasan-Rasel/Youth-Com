package com.youth.main.service;

import com.youth.main.model.User;
import com.youth.main.web.dto.UserRegistrationDto;

public interface UserService {
	User save(UserRegistrationDto registrationDto);
}
