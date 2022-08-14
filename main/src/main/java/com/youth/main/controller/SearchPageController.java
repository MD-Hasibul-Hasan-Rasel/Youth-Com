package com.youth.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.youth.main.model.CartModel;
import com.youth.main.model.ProductModel;
import com.youth.main.repository.CartRepository;
import com.youth.main.service.ProductServiceImpl;

@Controller
public class SearchPageController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Autowired
	private CartRepository cartRepository;
	
	@GetMapping("/searchpage")
	public String searchPage(ProductModel productModel, Model model, String keyword) {
		
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String username = loggedInUser.getName();
		
		if(keyword!=null) {
			List<ProductModel> list = productServiceImpl.getByKeyword(keyword);
			int productlistsize = list.size();
			
			model.addAttribute("productlistsize", productlistsize);
			model.addAttribute("list", list);
			model.addAttribute("username", username);
			
			List<CartModel> listcart = cartRepository.findByUsernameIgnoreCase(username);
		    int listcount = listcart.size();
		    
		    model.addAttribute("listCart",listcart);
		    model.addAttribute("count",listcount);
		}else {
			List<ProductModel> list = productServiceImpl.getAllShops();
			int productlistsize = list.size();
			
			model.addAttribute("productlistsize", productlistsize);
			model.addAttribute("list", list);
			model.addAttribute("username", username); 
			
			List<CartModel> listcart = cartRepository.findByUsernameIgnoreCase(username);
		    int listcount = listcart.size();
		    
		    model.addAttribute("listCart",listcart);
		    model.addAttribute("count",listcount);
		}
			  
		
		return "searchpage";
	}
	
	@GetMapping("/searchpageAside")
	public String searchPage(@RequestParam(required=false,name="keyword") String keyword, ProductModel productModel, Model model) {
		
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String username = loggedInUser.getName();
		
		if(keyword!=null) {
			List<ProductModel> list = productServiceImpl.getByKeyword(keyword);
			int productlistsize = list.size();
			
			model.addAttribute("productlistsize", productlistsize);
			
			model.addAttribute("list", list);
			model.addAttribute("username", username);
			
			List<CartModel> listcart = cartRepository.findByUsernameIgnoreCase(username);
		    int listcount = listcart.size();
		    
		    model.addAttribute("listCart",listcart);
		    model.addAttribute("count",listcount);
		}else {
			List<ProductModel> list = productServiceImpl.getAllShops();
			int productlistsize = list.size();
			
			model.addAttribute("productlistsize", productlistsize);
			model.addAttribute("list", list);
			model.addAttribute("username", username); 
			
			List<CartModel> listcart = cartRepository.findByUsernameIgnoreCase(username);
		    int listcount = listcart.size();
		    
		    model.addAttribute("listCart",listcart);
		    model.addAttribute("count",listcount);
		}
		
		return "searchpage";
	}
}
























