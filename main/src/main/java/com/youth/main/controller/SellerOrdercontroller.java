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

import com.youth.main.controller.dto.OrderReceivedDto;
import com.youth.main.controller.dto.OrdersDto;
import com.youth.main.model.DeliveredModel;
import com.youth.main.model.OrderModel;
import com.youth.main.model.UserModel;
import com.youth.main.repository.DeliveredRepository;
import com.youth.main.repository.OrderRepository;
import com.youth.main.service.UserService;

@Controller
public class SellerOrdercontroller {

	   @Autowired
	   private UserService userService;
	   
	   @Autowired
	   private OrderRepository orderRepository;
	   
	   @Autowired
	   private DeliveredRepository deliveredRepository;

	   @GetMapping("/seller/seller_orders")
	   public String userProfile(Model model) {
		   Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		   String username = loggedInUser.getName(); 
		   String pending = "pending";

		   UserModel userData = userService.findByUsername(username);

		   model.addAttribute("userdata", userData);
		   model.addAttribute("username",username);
		   
		   List<OrderModel> pendinglist = orderRepository.findByKeyword(username,pending);
		   model.addAttribute("pendinglist", pendinglist);
		   model.addAttribute("orderconfirm", new OrderReceivedDto());
		   
		   return "seller_orders";
	   }
	   
	   @PostMapping("/seller/seller_orders")
		public String userOrdersCreate(@Valid @ModelAttribute("orderconfirm") OrderReceivedDto orderDto,
										  BindingResult result,
										  Model model,
										  HttpSession session) {
		   
		   
		   OrderModel orderModel = orderRepository.findByUsername(orderDto.getUsername());
		   String status = "delivered";

		   
		   Long id = orderModel.getId();
		   
		   if(orderModel.getOtp().equalsIgnoreCase(orderDto.getOtp())) {
			   
			   DeliveredModel delivered = new DeliveredModel(
					    orderModel.getUsername(),
					    orderModel.getUseremail(),
					    orderModel.getOtp(),
					    orderModel.getQuantity(),
					    orderModel.getUseraddress(),
					    orderModel.getProductimg(),
					    orderModel.getProductname(),
					    orderModel.getProductno(),
					    orderModel.getSellername(),
						"delivered",
						orderModel.getPrice());
			   
			   deliveredRepository.save(delivered);
			   
			   orderRepository.deleteById(id);
		   }
		   
		   
		   
		   return "redirect:/seller/seller_orders";
	   }
}



















