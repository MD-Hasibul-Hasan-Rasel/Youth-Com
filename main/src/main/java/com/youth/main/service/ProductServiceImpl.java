package com.youth.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youth.main.controller.dto.ProductDto;
import com.youth.main.model.ProductModel;
import com.youth.main.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Optional < ProductModel > findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List < ProductModel > findAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(long id) {
    	productRepository.deleteById(id);
    }

	@Override
	public ProductModel findByUsername(String username) {
		return productRepository.findByUsername(username);
	}
	
	@Override
	public List<ProductModel> findByUsernameIgnoreCase(String username) {
		
		return productRepository.findByUsernameIgnoreCase(username);
	}

    @Override
    public ProductModel save(ProductDto productDto) {
        ProductModel productModel = new ProductModel(
                productDto.getUsername(),
				productDto.getProductno(),
				productDto.getProductname(),
				productDto.getPrice(),
				productDto.getOffer(),
				productDto.getDescription(),
				productDto.getProductno()+".jpg");
		
		return productRepository.save(productModel);
    }
    
    /*searching products*/
    /*Search for all products*/
    public List<ProductModel> getAllShops(){
    	List<ProductModel> list =  (List<ProductModel>)productRepository.findAll();
    	return list;
    }
    	 
    /*Search for desired products only*/
    public List<ProductModel> getByKeyword(String keyword){
    	return productRepository.findByKeyword(keyword);
    }

    /*@Override
    public ProductModel update(ProductDto productDto) {
        // TODO Auto-generated method stub
        return null;
    }*/
    
}
