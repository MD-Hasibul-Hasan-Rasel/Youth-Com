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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.youth.main.controller.dto.ProductDto;
import com.youth.main.controller.dto.UserRegistrationDto;
import com.youth.main.mailservice.EmailDetails;
import com.youth.main.mailservice.EmailService;
import com.youth.main.model.ProductModel;
import com.youth.main.model.UserModel;
import com.youth.main.repository.ProductRepository;
import com.youth.main.repository.UserRepository;
import com.youth.main.service.ProductService;
import com.youth.main.service.ProductServiceImpl;
import com.youth.main.service.UserServiceImpl;

@Controller
@RequestMapping("/seller/seller_products")
public class SellerProductsController {

    @Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;
    
    @GetMapping
	public String products(Model model){

		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String username = loggedInUser.getName(); 

	    UserModel getActualUsername = userRepository.findByUsername(username);
	    String originalUsername = getActualUsername.getUsername();
	    
	    List<ProductModel> productlist = productService.findByUsernameIgnoreCase(originalUsername);
	    
	    
	    productlist.forEach(employee -> System.out.println(employee.toString()));
	    
	    model.addAttribute("username", originalUsername);
	    model.addAttribute("products", productlist);
	    model.addAttribute("size", productlist.size());
	    
		model.addAttribute("product", new ProductDto());
		return "seller_products";

	}


	@PostMapping
	public String updateproduct(@Valid @ModelAttribute("product") ProductDto productDto,
									  BindingResult result,
									  Model model,
									  HttpSession session,
									  @RequestParam("image") MultipartFile multipartFile) throws IOException{
      
		try {
			session.removeAttribute("message");
			
			if(result.hasErrors()) {
				model.addAttribute("product",productDto);
				session.setAttribute("message","Server error has occured. Please try again.");
				return "seller_products";
			}
			
			String username = productDto.getUsername();
			ProductModel product = productServiceImpl.findByUsername(username);
			
			if(product!=null) {
				model.addAttribute("product",productDto);
				session.setAttribute("message","Product update successful.");
				return "seller_products";
			}
			
			
				/*image upload*/
				String fileName = productDto.getProductno()+".jpg";
				productDto.setPhotos(fileName);
				
				
				/*save data to database*/
				productServiceImpl.save(productDto);
								
		        String uploadDir = "./src/main/resources/static/uploads/" + productDto.getUsername() + "/" + productDto.getProductno();
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
		        
				model.addAttribute("product",productDto);
				session.setAttribute("message","Product update successful.");
			
			
		}catch(Exception e) {
//			session.setAttribute("message","Error updating product. "+e.getMessage());
			session.setAttribute("message","Error updating product.");
		}
	     
	   
		return "redirect:/seller/seller_products?success";
	}


}
