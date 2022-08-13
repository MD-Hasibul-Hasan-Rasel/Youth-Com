package com.youth.main.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.youth.main.controller.dto.PostDto;
import com.youth.main.model.PostModel;
import com.youth.main.model.UserModel;
import com.youth.main.repository.PostRepository;
import com.youth.main.repository.UserRepository;
import com.youth.main.service.PostService;
import com.youth.main.service.PostServiceImpl;

@Controller
@RequestMapping("/seller/seller_post_management")
public class SellerPostController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PostServiceImpl postServiceImpl;

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public String products(Model model){
		
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String username = loggedInUser.getName(); 

	    UserModel getActualUsername = userRepository.findByUsername(username);
	    String originalUsername = getActualUsername.getUsername();
	    
	    List<PostModel> postlist = postService.findByUsernameIgnoreCase(originalUsername);
	    
	    
	    postlist.forEach(employee -> System.out.println(employee.toString()));
	    
	    model.addAttribute("username", originalUsername);
	    model.addAttribute("posts", postlist);
	    model.addAttribute("size", postlist.size());
	    
		model.addAttribute("post", new PostDto());
		
		return "seller_post_management";
	}
	
	@PostMapping
	public String updateproduct(@Valid @ModelAttribute("post") PostDto postDto,
									  BindingResult result,
									  Model model,
									  HttpSession session,
									  @RequestParam("image") MultipartFile multipartFile) throws IOException{
		
		
		try {
			session.removeAttribute("message");
			
			if(result.hasErrors()) {
				model.addAttribute("post",postDto);
				session.setAttribute("message","Server error has occured. Please try again.");
				return "seller_post_management";
			}
			
			String username = postDto.getUsername();
			PostModel product = postServiceImpl.findByUsername(username);
			
			if(product!=null) {
				model.addAttribute("post",postDto);
				session.setAttribute("message","Post update successful.");
				return "seller_post_management";
			}
			

//			image upload
			String fileName = postDto.getPostname()+".jpg";
			postDto.setPhotos(fileName);
			
			
//			save data to database
			postServiceImpl.save(postDto);
							
	        String uploadDir = "./src/main/resources/static/uploads/" + postDto.getUsername() + "/postdata/" + postDto.getPostname();
	        Path uploadPath = Paths.get(uploadDir);
	        
	        
	        if(!Files.exists(uploadPath)){
	        	Files.createDirectories(uploadPath);
	        }
	        
	        try (InputStream inputstream = multipartFile.getInputStream()){
	        	Path filePath = uploadPath.resolve(fileName);
	        	Files.copy(inputstream, filePath, StandardCopyOption.REPLACE_EXISTING);
	        	
	        }catch(IOException e) {
	        	throw new IOException("Couldn't save the uploaded image."+fileName);
	        }
	        
			model.addAttribute("post",postDto);
			session.setAttribute("message","Product update successful.");
			
		
		}catch(Exception e) {
			session.setAttribute("message","Error updating product.");
		}
		
		return "redirect:/seller/seller_post_management?success";
		
		
	}
}
	



















