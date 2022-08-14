package com.youth.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.youth.main.model.PostModel;
import com.youth.main.model.ProductModel;
import com.youth.main.service.PostServiceImpl;

@Controller
public class BlogpostController {
	
	@Autowired
	private PostServiceImpl postServiceImpl;
	
	
	@GetMapping("/user/blogpost")
	public String searchPage(@RequestParam(required=false,name="category") String category, ProductModel productModel, Model model, String keyword) {
		
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String username = loggedInUser.getName();
	    
	    if(category!=null) {
			List<PostModel> list = postServiceImpl.getByKeyword(category);
			model.addAttribute("list", list);
			model.addAttribute("username", username);
			model.addAttribute("size", list.size());
			
	    
	    }else if(keyword!=null) {
			List<PostModel> list = postServiceImpl.getByKeyword(keyword);
			model.addAttribute("list", list);
			model.addAttribute("username", username);
			model.addAttribute("size", list.size());
			
		}else {
			List<PostModel> list = postServiceImpl.getAllPosts();
			model.addAttribute("list", list);
			model.addAttribute("username", username);
			model.addAttribute("size", list.size());
			
		}
	    
		
		return "blogpost";
}
	    

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
