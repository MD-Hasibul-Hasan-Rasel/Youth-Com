package com.youth.main.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.youth.main.model.CartModel;
import com.youth.main.model.UserModel;
import com.youth.main.repository.CartRepository;
import com.youth.main.repository.UserRepository;
import com.youth.main.service.ProductServiceImpl;

@Controller
public class UserDeleteCartController {
	
//	@Autowired
//	private UserRepository userRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	
	@GetMapping("/deleteCartindex")
	public String deleteProduct(@RequestParam Long cartId) throws IOException {
		
//		for username
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String username = loggedInUser.getName(); 
	    

//	    For deleting data from database
	    cartRepository.deleteById(cartId);
		
		return "redirect:/index";
	}
	
	@GetMapping("/deleteCartsearchpage")
	public String deleteProductSearchpage(@RequestParam Long cartId){
		
//	    For deleting data from database
	    cartRepository.deleteById(cartId);
		
		return "redirect:/searchpage";
	}
	
	@GetMapping("/deleteCartproduct")
	public String deleteProductPage(@RequestParam Long cartId) {
		
	    

//	    For deleting data from database
	    cartRepository.deleteById(cartId);
		
		return "redirect:/searchpage";
	}
	
	@GetMapping("/deleteAllCart")
	public String deleteAll(@RequestParam String cartusername) throws IOException {
		
//		for username
//		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
//	    String username = loggedInUser.getName(); 
	    

//	    For deleting data from database
//	    cartRepository.delete;
		
		return "redirect:/index";
	}
}









