package com.youth.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.youth.main.controller.dto.UserRegistrationDto;
import com.youth.main.model.CartModel;
import com.youth.main.model.UserModel;
import com.youth.main.repository.CartRepository;
import com.youth.main.repository.UserRepository;

@Controller
//@RequestMapping(value={"/", "/user"})
public class HomepageController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	CartRepository cartRepository;

	@GetMapping(value={"/","/index"})
	public String homeC(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result, Model model) {

		try {
	    Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String username = loggedInUser.getName(); 

	    
	    UserModel getActualUsername = userRepository.findByUsername(username);
	    String originalUsername = getActualUsername.getUsername();
	    
	    List<CartModel> listcart = cartRepository.findByUsernameIgnoreCase(username);
	    int listcount = listcart.size();
	    
	    model.addAttribute("listCart",listcart);
	    model.addAttribute("count",listcount);

		
	    model.addAttribute("username", originalUsername);
	    
		}catch(Exception e) {
			System.out.println("User is anonymous");
		}
	   
		return "index"; 
		
	}
}











