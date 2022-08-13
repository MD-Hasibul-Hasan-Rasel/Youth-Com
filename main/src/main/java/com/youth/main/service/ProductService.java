package com.youth.main.service;

import java.util.List;
import java.util.Optional;

import com.youth.main.controller.dto.ProductDto;
import com.youth.main.model.ProductModel;

public interface ProductService {
    List<ProductModel> findAll();
    
    List<ProductModel> findByUsernameIgnoreCase(String username);
    
//    void save(ProductModel employee);

    Optional < ProductModel > findById(Long id);

    void delete(long id);
    
	ProductModel findByUsername(String username);
	
    ProductModel save(ProductDto productDto);
    
//    ProductModel update(ProductDto productDto);
}
