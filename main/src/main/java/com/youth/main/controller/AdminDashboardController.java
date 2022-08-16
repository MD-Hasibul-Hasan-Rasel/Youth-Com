package com.youth.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.youth.main.model.DeliveredModel;
import com.youth.main.repository.DeliveredRepository;
import com.youth.main.repository.UserRepository;

@Controller
public class AdminDashboardController {
	
	
	@Autowired
	DeliveredRepository deliveredRepository;
	
	@GetMapping("/admin/admin_dashboard")
	public String adminDashboard(Model model) {
		
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String username = loggedInUser.getName(); 
		
		String delivered = "delivered";
		
		List<DeliveredModel> deliveredList = deliveredRepository.findByKeyword(delivered);
		
		int buyercount = deliveredList.size();
		
		int totalprice = 0;
		
        for (int i = 0; i < deliveredList.size(); i++) {
        	String price = deliveredList.get(i).getPrice();
        	Integer priceint = Integer.valueOf(price);
        	
        	totalprice += priceint;
        }
        
        double percentage = totalprice * 0.05;
		
		
		model.addAttribute("delivered",deliveredList);
		model.addAttribute("totalprice",totalprice);
		model.addAttribute("buyercount",buyercount);
		model.addAttribute("percentage",percentage);
		model.addAttribute("username", username);
		
		return "admin_dashboard";
	}
}

//		String s="200";  
//converting String into Integer using Integer.valueOf() method  
//		Integer i=Integer.valueOf(s);  