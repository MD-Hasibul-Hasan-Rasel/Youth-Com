package com.youth.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.youth.main.mailservice.EmailService;

@Controller
public class UserLoginController {

	@Autowired 
	private EmailService emailService;
	
	@GetMapping("/login")
	public String userlogin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.getPrincipal() instanceof UserDetails) {
			return "redirect:/index";
		}else {
					
//			Email sending for checking purpose only..	               
	        /*EmailDetails emailDetails = new EmailDetails();
	        emailDetails.setRecipient("usecase22a@gmail.com");
	        emailDetails.setSubject("Sign in successful.");
	        emailDetails.setMsgBody("<h1 style='color:#3fa9f5;'>Youth Com.</h1>"
	        		+ "<span style='color: #51cf66; font-weight: bold;'>Login Successful.</span>"
	        		+ "Dear Sir/Madam, thanks for logging in.");
	        emailDetails.setAttachment("./src/main/resources/static/images/base_logo02.png");
	        
	        emailService.sendMailWithHTMLOnly(emailDetails);*/
			
			return "login";
		}
	}

}
