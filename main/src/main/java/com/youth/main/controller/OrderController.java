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
import org.springframework.web.bind.annotation.RequestMapping;

import com.youth.main.controller.dto.OrdersDto;
import com.youth.main.mailservice.EmailDetails;
import com.youth.main.mailservice.EmailService;
import com.youth.main.model.OrderModel;
import com.youth.main.model.ProductModel;
import com.youth.main.model.UserModel;
import com.youth.main.repository.OrderRepository;
import com.youth.main.repository.UserRepository;
import com.youth.main.service.ProductServiceImpl;

@Controller
@RequestMapping("/user/orders")
public class OrderController {
	
	@Autowired 
	ProductServiceImpl productServiceImpl;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	private EmailService emailService;
	
	@GetMapping
	public String userOrders(Model model, String keyword) {
		List<ProductModel> productlist = productServiceImpl.getByKeyword(keyword);
		model.addAttribute("list", productlist);
		model.addAttribute("orders", new OrdersDto());
		
		return "orders";
	}
	
	@PostMapping
	public String userOrdersCreate(@Valid @ModelAttribute("orders") OrdersDto ordersDto,
									  BindingResult result,
									  Model model,
									  HttpSession session) {
			
			model.addAttribute("orders", new OrdersDto());
			
			Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
			String usernameCurrent = loggedInUser.getName();
			
			UserModel userModel = userRepository.findByUsername(usernameCurrent);
			
			String keyword = ordersDto.getProductname();

			List<ProductModel> productlist = productServiceImpl.getByKeyword(keyword);
			model.addAttribute("list", productlist);
			
			
//			for generating otp 
			Double d = Math.random()*1000000;
			int i=d.intValue(); 
			String otp = String.valueOf(i);
			
			OrderModel orderModel = new OrderModel(
					usernameCurrent,
					userModel.getEmail(),
					otp,
					ordersDto.getQuantity(),
					ordersDto.getUseraddress(),
					productlist.get(0).getPhotos(),
					productlist.get(0).getProductname(),
					productlist.get(0).getProductno(),
					productlist.get(0).getUsername(),
					"pending",
					productlist.get(0).getPrice());
			
			orderRepository.save(orderModel);
			
//			Email sending for checking purpose only..	               
	        EmailDetails emailDetails = new EmailDetails();
	        emailDetails.setRecipient(userModel.getEmail());
	        emailDetails.setSubject("Your purchase was successful.");
	        emailDetails.setMsgBody("<h1 style='color:#3fa9f5;'>Youth Com.</h1>"
	        		+ "<span style='color: #51cf66; font-weight: bold;'>You have made a successful "
	        		+ "purchase.</span><br/>"
	        		+ "Dear Sir/Madam, your purchase otp is : "+ otp
	        		+ "<p style='color:#fa5252;'>Please do not share your otp with anyone"
	        		+ " until your order reaches you.</p>"
	        		+ "<p style='color:#51cf66;'>Only provide this otp to the seller after your product "
	        		+ "is properly delivered to you.</p>"
	        		+ "<br/>"
	        		+ "<p>Thanks for choosing <span style='color:#3fa9f5;' >Youth Com</span> </p>"	);
	        emailDetails.setAttachment("./src/main/resources/static/images/base_logo02.png");
	        
	        emailService.sendMailWithHTMLOnly(emailDetails);
			
		
		return "redirect:/index";
		
	}
	

}
