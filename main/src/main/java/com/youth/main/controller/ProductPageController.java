package com.youth.main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.youth.main.controller.dto.ReportDto;
import com.youth.main.model.CartModel;
import com.youth.main.model.ProductModel;
import com.youth.main.repository.CartRepository;
import com.youth.main.service.ProductServiceImpl;


@Controller
public class ProductPageController {

	@Autowired
	CartRepository cartRepository;
		
	@Autowired
	private ProductServiceImpl productServiceImpl;
		
	@GetMapping("/product_page")
		public String searchPage(ProductModel productModel, Model model, String keyword) {
			
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String username = loggedInUser.getName();
			
		if(keyword!=null) {
			List<ProductModel> list = productServiceImpl.getByKeyword(keyword);
			model.addAttribute("list", list);
			
		}
		else {
			List<ProductModel> list = productServiceImpl.getAllShops();
			model.addAttribute("list", list);
			model.addAttribute("username", username); 
			
			
		}
				  
		model.addAttribute("username", username);
			
			List<CartModel> listcart = cartRepository.findByUsernameIgnoreCase(username);
			int count = listcart.size();
		    model.addAttribute("listCart",listcart);
			
			model.addAttribute("count",count);	
			
		return "product_page";
	}
	
	@PostMapping("/user/product_page")
	public String userOrdersCreate(@Valid @ModelAttribute("orderconfirm") ReportDto reportDto,
									  BindingResult result,
									  Model model,
									  HttpSession session) {
		
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String username = loggedInUser.getName(); 
		
		List<ProductModel> rlist = productServiceImpl.getByKeyword(reportDto.getProductname());
		
		
		return "redirect:/index";
	}
}


















