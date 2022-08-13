package com.youth.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.youth.main.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    
    ProductModel findByUsername(String username);

    List<ProductModel> findByUsernameIgnoreCase(String username);
    
    /*For searching products*/
    @Query(value = "select * from products p where p.productname like %:keyword%", nativeQuery = true)
    List<ProductModel> findByKeyword(@Param("keyword") String keyword);
}
