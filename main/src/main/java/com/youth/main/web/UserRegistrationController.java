package com.youth.main.web;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.youth.main.filehandle.FileUploadUtil;
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
//
//   public UserRegistrationController(UserService userService) {
//      super();
//      this.userService = userService;
//   }
	
//	private UserRepository userRepository;


//	public UserRegistrationController(UserRepository userRepository) {
//	    super();
//	    this.userRepository = userRepository;
//	}

//	@ModelAttribute("user")
//	public UserRegistrationDto userRegistrationDto() {
//		return new UserRegistrationDto();
//	}

	@GetMapping
	public String RegistrationForm(Model model) {
		model.addAttribute("user", new UserRegistrationDto());
		return "user_registration";
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
				String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
				userRegistrationDto.setPhoto(fileName);
//		        User savedUser = repo.save(user);
		        String uploadDir = "uploads/" + userRegistrationDto.getUsername();
		        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
				
				userServiceImpl.save(userRegistrationDto);
				
				model.addAttribute("user",userRegistrationDto);
				session.setAttribute("message","Registration successful.");
			}else {
				model.addAttribute("user",userRegistrationDto);
				session.setAttribute("message","Provided passwords are not same.");
				return "redirect:/user_registration";
			}
			
			
		}catch(Exception e) {
//			session.setAttribute("message","Error Signing up user."+e.getMessage());
			session.setAttribute("message","Error Signing up user. This issue maybe due to"
					+ " already existing email address or other credentials. Please try with different ones.");
		}
	     
	   
		return "redirect:/user_registration?success";
	}
}





















