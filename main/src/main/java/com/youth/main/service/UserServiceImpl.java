package com.youth.main.service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youth.main.controller.dto.UserRegistrationDto;
import com.youth.main.model.UserModel;
import com.youth.main.repository.RoleRepository;
import com.youth.main.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public UserModel findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public UserModel save(UserRegistrationDto registrationDto) {
		UserModel userModel = new UserModel(
				registrationDto.getFirstName(),
				registrationDto.getLastName(),
				registrationDto.getUsername(),
				registrationDto.getEmail(),
				registrationDto.getPassword(),
				registrationDto.getPhoto(),
				Arrays.asList(roleRepository.findByName(registrationDto.getUserRole())));
				// Arrays.asList(roleRepository.findByName("USER")));
		
		return userRepository.save(userModel);
	}
	
	/*@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserModel userModelLoad = userRepository.findByEmail(email);
		if(userModelLoad == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		return new org.springframework.security.core.userdetails.User(userModelLoad.getEmail(), userModelLoad.getPassword(), mapRolesToAuthorities(userModelLoad.getRoles()));		
		
	}	

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
	
	}*/


}



















