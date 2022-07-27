package com.youth.main.service;

import java.util.Arrays;

import com.youth.main.model.Role;
import com.youth.main.model.User;
import com.youth.main.repository.UserRepository;
import com.youth.main.web.dto.UserRegistrationDto;

public class UserServiceImplementation implements UserService{

	private UserRepository userRepository;
	
	public UserServiceImplementation(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(),
				registrationDto.getLastName(),registrationDto.getEmail(),
				registrationDto.getPhone(),registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}

}
