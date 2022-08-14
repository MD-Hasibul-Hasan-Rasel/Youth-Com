package com.youth.main.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youth.main.controller.dto.PostDto;
import com.youth.main.model.PostModel;
import com.youth.main.model.ProductModel;
import com.youth.main.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public Optional < PostModel > findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List < PostModel > findAll() {
        return postRepository.findAll();
    }

    @Override
    public void delete(long id) {
    	postRepository.deleteById(id);
    }

	@Override
	public PostModel findByUsername(String username) {
		return postRepository.findByUsername(username);
	}
	
	@Override
	public List<PostModel> findByUsernameIgnoreCase(String username) {
		
		return postRepository.findByUsernameIgnoreCase(username);
	}

    @Override
    public PostModel save(PostDto postDto) {
    	
//    	getting current date
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date(); 
    	
    	PostModel productModel = new PostModel(
    			postDto.getUsername(),
        		postDto.getCategory(),
        		formatter.format(date),
        		postDto.getPostname(),
        		postDto.getDescription(),
        		postDto.getPostname()+".jpg");
		
		return postRepository.save(productModel);
    }
    
    /*searching posts*/
    /*Search for all posts*/
    public List<PostModel> getAllPosts(){
    	List<PostModel> list =  (List<PostModel>)postRepository.findAll();
    	return list;
    }
    	 
    /*Search for desired posts only*/
    public List<PostModel> getByKeyword(String keyword){
    	return postRepository.findByKeyword(keyword);
    }
    
}




























