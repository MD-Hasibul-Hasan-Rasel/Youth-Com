package com.youth.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"/", "/user"})
public class HomepageController {

	@GetMapping
	public String home() {
		return "index"; 
	}

	@GetMapping("/index")
	public String homeD() {
		return "index"; 
	}
}
