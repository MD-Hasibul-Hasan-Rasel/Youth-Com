package com.youth.main.service;

import com.youth.main.controller.dto.UserRegistrationDto;
import com.youth.main.model.UserModel;


public interface UserService {
   
	UserModel findByUsername(String username);
   
    UserModel save(UserRegistrationDto registrationDto);
}
