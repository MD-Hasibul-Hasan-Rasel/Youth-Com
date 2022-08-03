package com.youth.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginController {
	
//	@Autowired
//	UserLoginDto userLoginDto;
	
//	@GetMapping("/user_login")
//	public String userlogin(Model model) {
//		UserLoginDto userLoginDto = new UserLoginDto();
//		model.addAttribute("user",userLoginDto);
//		return "user_login";
//	}
	

	@GetMapping("/user_login")
	public String userlogin() {
		return "user_login";
	}
	/*@Autowired
	   private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping
	public String loginHandler(@ModelAttribute("user") UserLoginDto userLoginDto) {
		System.out.println(userLoginDto.getEmail());
		System.out.println(userLoginDto.getPassword());
		
		/*String email = userLoginDto.getEmail();
		String password = passwordEncoder.encode(userLoginDto.getPassword());
		
		if("user".equals(email) && "user".equals(password)) {
			return "index";
		}
		
//		model.addAttribute("invalidCredentials", true);
		return "user_login";
	}*/

}
