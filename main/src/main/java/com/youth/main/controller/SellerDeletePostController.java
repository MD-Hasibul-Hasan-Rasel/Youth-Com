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

import com.youth.main.model.PostModel;
import com.youth.main.model.UserModel;
import com.youth.main.repository.UserRepository;
import com.youth.main.service.PostServiceImpl;


@Controller
public class SellerDeletePostController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostServiceImpl postServiceImpl;
	
	
	@GetMapping("/deletePost")
	public String deleteProduct(@RequestParam Long postId) throws IOException {
		
//		for username
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String username = loggedInUser.getName(); 

	    UserModel getActualUsername = userRepository.findByUsername(username);
	    String originalUsername = getActualUsername.getUsername();
	    
//	    for product no.
	    PostModel post = postServiceImpl.findByUsername(originalUsername);
		
	    Path fileToDeletePath = Paths.get("./src/main/resources/static/uploads/" + post.getUsername() + "/postdata/" + post.getPostname() + "/" + post.getPostname()+".jpg" );
	    Files.delete(fileToDeletePath);

//	    For deleting data from database
	    postServiceImpl.delete(postId);
		
		return "redirect:/seller/seller_post_management";
	}
}







