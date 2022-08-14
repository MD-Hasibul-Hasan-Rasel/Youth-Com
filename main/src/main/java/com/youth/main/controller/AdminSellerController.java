package com.youth.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.youth.main.model.UserModel;
import com.youth.main.service.UserService;

@Controller
public class AdminSellerController {

	   @Autowired
	   private UserService userService;

	   @GetMapping("/admin/admin_sellers")
	   public String userProfile(Model model) {
//		   Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
//		   String username = loggedInUser.getName(); 
//
//		   UserModel userData = userService.findByUsername(username);
//
//		   model.addAttribute("userdata", userData);
//		   model.addAttribute("username",username);
		   return "admin_sellers";
	   }
	   
	   
}