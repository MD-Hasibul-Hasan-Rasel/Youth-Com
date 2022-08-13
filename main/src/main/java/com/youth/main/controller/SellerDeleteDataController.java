package com.youth.main.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.youth.main.model.ProductModel;
import com.youth.main.model.UserModel;
import com.youth.main.repository.UserRepository;
import com.youth.main.service.ProductServiceImpl;

@Controller
public class SellerDeleteDataController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam Long productId) throws IOException {
		
//		for username
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String username = loggedInUser.getName(); 

	    UserModel getActualUsername = userRepository.findByUsername(username);
	    String originalUsername = getActualUsername.getUsername();
	    
//	    for product no.
	    ProductModel product = productServiceImpl.findByUsername(originalUsername);
		
	    Path fileToDeletePath = Paths.get("./src/main/resources/static/uploads/" + product.getUsername() + "/" + product.getProductno() + "/" + product.getProductno()+".jpg" );
	    Files.delete(fileToDeletePath);

//	    For deleting data from database
	    productServiceImpl.delete(productId);
		
		return "redirect:/seller/seller_products";
	}
}









