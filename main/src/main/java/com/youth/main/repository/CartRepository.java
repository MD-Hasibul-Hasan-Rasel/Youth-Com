package com.youth.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.youth.main.model.CartModel;
import com.youth.main.model.PostModel;
import com.youth.main.model.ProductModel;

@Repository
public interface CartRepository  extends JpaRepository<CartModel, Long> {
    
	CartModel findByUsername(String username);

    List<CartModel> findByUsernameIgnoreCase(String username);
    
    /*For searching posts*/
    @Query(value = "select * from products p where p.productname like %:keyword%",  nativeQuery = true)
    List<CartModel> findByKeyword(@Param("keyword") String keyword);
}
