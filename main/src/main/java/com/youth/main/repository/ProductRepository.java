package com.youth.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youth.main.model.Category;
import com.youth.main.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
