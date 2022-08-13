package com.youth.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.youth.main.model.ProductModel;
import com.youth.main.service.ProductServiceImpl;

@Controller
public class SearchPageController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@GetMapping("/searchpage")
	public String searchPage(ProductModel productModel, Model model, String keyword) {
		
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String username = loggedInUser.getName();
		
		if(keyword!=null) {
			List<ProductModel> list = productServiceImpl.getByKeyword(keyword);
			model.addAttribute("list", list);
			model.addAttribute("username", username);
		}else {
			List<ProductModel> list = productServiceImpl.getAllShops();
			model.addAttribute("list", list);
			model.addAttribute("username", username);  
		}
			  
		
		return "searchpage";
	}
}
