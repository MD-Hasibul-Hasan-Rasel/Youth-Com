package com.youth.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.youth.main.model.CartModel;
import com.youth.main.model.ProductModel;
import com.youth.main.repository.CartRepository;
import com.youth.main.service.ProductServiceImpl;

@Controller
public class AddCartController {
	
	@Autowired 
	ProductServiceImpl productServiceImpl;
	
	@Autowired
	CartRepository cartRepository;
	
	@GetMapping("/user/addcart")
	public String addCart(ProductModel productModel, Model model, String keyword) {
		
//		for username
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String username = loggedInUser.getName();
	    
	    if(keyword!=null) {
			ProductModel productModel2 = productServiceImpl.findByUsername(keyword);
			
			CartModel cartModel = new CartModel(
					username,
					productModel2.getProductno(),
					productModel2.getProductname(),
					productModel2.getUsername(),
					productModel2.getPhotos()
					);
			
			cartRepository.save(cartModel);
			
//			model.addAttribute("cartadd","Cart added");
//			
//			List<CartModel> listcart = cartRepository.findByUsernameIgnoreCase(username);
//			int count = listcart.size();
//		    model.addAttribute("listCart",listcart);
//			
//			model.addAttribute("count",count);
			
	    }else {
	    	System.out.println("keyword is null");
	    }
	    
		
		return "redirect:/searchpage";
		
	}
}




















