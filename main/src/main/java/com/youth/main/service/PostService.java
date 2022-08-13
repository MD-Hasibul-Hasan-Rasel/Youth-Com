package com.youth.main.service;

import java.util.List;
import java.util.Optional;

import com.youth.main.controller.dto.PostDto;
import com.youth.main.model.PostModel;

public interface PostService {
	
	 	List<PostModel> findAll();
	    
	    List<PostModel> findByUsernameIgnoreCase(String username);

	    Optional < PostModel > findById(Long id);

	    void delete(long id);
	    
	    PostModel findByUsername(String username);
		
	    PostModel save(PostDto postDto);

}
