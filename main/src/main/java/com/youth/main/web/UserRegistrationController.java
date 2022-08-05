package com.youth.main.web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.youth.main.mailservice.EmailDetails;
import com.youth.main.mailservice.EmailService;
import com.youth.main.model.UserModel;
import com.youth.main.service.UserServiceImpl;
import com.youth.main.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/user_registration")
public class UserRegistrationController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired 
	private EmailService emailService;

	@GetMapping
	public String RegistrationForm(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.getPrincipal() instanceof UserDetails) {
			return "redirect:/index";
		}else {
			model.addAttribute("user", new UserRegistrationDto());
			return "user_registration";
		}
		
	}

	
	@PostMapping
	public String registerUserAccount(@Valid @ModelAttribute("user") UserRegistrationDto userRegistrationDto,
									  BindingResult result,
									  Model model,
									  HttpSession session,
									  @RequestParam("image") MultipartFile multipartFile) throws IOException{
      
		try {
			session.removeAttribute("message");
			
			if(result.hasErrors()) {
				model.addAttribute("user",userRegistrationDto);
				session.setAttribute("message","Server error has occured. Please try again.");
				return "user_registration";
			}
			
			String email = userRegistrationDto.getEmail();
			UserModel user = userServiceImpl.findByUsername(email);
			
			if(user!=null) {
				model.addAttribute("user",userRegistrationDto);
				session.setAttribute("message","Email registration successful.");
				return "user_registration";
			}
			
			if(userRegistrationDto.getPassword().equals(userRegistrationDto.getRetypepassword())) {
				userRegistrationDto.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
				
				
//				image upload
//				String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
				String fileName = userRegistrationDto.getUsername()+".jpg";
				userRegistrationDto.setPhoto(fileName);
				
//				save data to database
				userServiceImpl.save(userRegistrationDto);
								
		        String uploadDir = "./src/main/resources/static/uploads/" + userRegistrationDto.getUsername();
		        Path uploadPath = Paths.get(uploadDir);
		        
//				Email sending		               
		        EmailDetails emailDetails = new EmailDetails();
		        emailDetails.setRecipient(email);
		        emailDetails.setSubject("Registration successfull.");
		        emailDetails.setMsgBody("Dear Sir/Madam, we are very happy to have you with us. Start shopping . Or you can also "
        				+ "join the community.");
		        
		        emailService.sendSimpleMail(emailDetails);
		        
		        
		        if(!Files.exists(uploadPath)){
		        	Files.createDirectories(uploadPath);
		        }
		        
		        try (InputStream inputstream = multipartFile.getInputStream()){
		        	Path filePath = uploadPath.resolve(fileName);
		        	Files.copy(inputstream, filePath, StandardCopyOption.REPLACE_EXISTING);
		        	
		        }catch(IOException e) {
		        	throw new IOException("Couldn't save the uploaded image."+fileName);
		        }
		        
		        
		        
				model.addAttribute("user",userRegistrationDto);
				session.setAttribute("message","Registration successful.");
			}else {
				model.addAttribute("user",userRegistrationDto);
				session.setAttribute("message","Provided passwords are not same.");
				return "redirect:/user_registration";
			}
			
			
		}catch(Exception e) {
			session.setAttribute("message","Error Signing up user."+e.getMessage());
//			session.setAttribute("message","Error Signing up user. This issue maybe due to"
//					+ " already existing email address or other credentials. Please try with different ones.");
		}
	     
	   
		return "redirect:/user_registration?success";
	}
}





















