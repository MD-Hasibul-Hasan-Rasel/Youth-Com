package com.youth.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.youth.main.service.UserService;
import com.youth.main.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/user_registration")
public class UserRegistrationController {
	
	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	public UserRegistrationController() {
		super();
	}

	@GetMapping
	public String userRegistrationForm() {
		return "user_registration"; 
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/user_login?success";
	}

}
