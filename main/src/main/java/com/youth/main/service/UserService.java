package com.youth.main.service;

import com.youth.main.model.UserModel;
import com.youth.main.web.dto.UserRegistrationDto;


public interface UserService {
   
	UserModel findByUsername(String username);
   
    UserModel save(UserRegistrationDto registrationDto);
}
