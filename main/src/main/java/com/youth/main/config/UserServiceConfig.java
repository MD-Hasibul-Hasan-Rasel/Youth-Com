package com.youth.main.config;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.youth.main.model.UserModel;
import com.youth.main.repository.UserRepository;

public class UserServiceConfig implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserModel userModel = userRepository.findByUsername(username);
		
		if(userModel==null) {
			throw new UsernameNotFoundException("User not found");
		}

		return new User(
				userModel.getUsername(),
				userModel.getPassword(),
				userModel.getRoles()
				.stream()
				.map(role->new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList()));
		
	}

}
