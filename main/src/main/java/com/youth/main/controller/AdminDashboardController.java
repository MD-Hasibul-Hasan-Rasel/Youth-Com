package com.youth.main.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.youth.main.controller.dto.UserRegistrationDto;
import com.youth.main.model.UserModel;
import com.youth.main.repository.UserRepository;

@Controller
public class AdminDashboardController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping(value={"/admin/admin_dashboard"})
	public String sellerDashboard(@ModelAttribute("admin") @Valid UserRegistrationDto userDto, BindingResult result, Model model) {

		try {
	    Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String username = loggedInUser.getName(); 

	    UserModel getActualUsername = userRepository.findByUsername(username);
	    String originalUsername = getActualUsername.getUsername();


	    model.addAttribute("username", originalUsername);
	    
		}catch(Exception e) {
			System.out.println("User is anonymous");
		}
	   
		return "admin_dashboard"; 
		
	}

	
















}
