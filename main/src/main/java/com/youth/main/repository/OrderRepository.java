package com.youth.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.youth.main.model.CartModel;
import com.youth.main.model.OrderModel;
import com.youth.main.model.PostModel;
import com.youth.main.model.ProductModel;

@Repository
public interface OrderRepository  extends JpaRepository<OrderModel, Long> {
    
	OrderModel findByUsername(String username);

    List<OrderModel> findByUsernameIgnoreCase(String username);

    @Query(value = "select * from orders o where o.sellername like %:keyword% and o.status like %:pending%",  nativeQuery = true)
    List<OrderModel> findByKeyword(@Param("keyword") String keyword, @Param("pending") String pending);

    @Modifying
    @Query(value="update Orders o set o.status =:status where o.id =:productid", nativeQuery = true)
    List<OrderModel> updateStatus(@Param("productid") String productid, @Param("status") String status);

}