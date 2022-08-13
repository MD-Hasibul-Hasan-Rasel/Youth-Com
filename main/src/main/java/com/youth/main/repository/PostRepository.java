package com.youth.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.youth.main.model.PostModel;
import com.youth.main.model.ProductModel;

@Repository
public interface PostRepository  extends JpaRepository<PostModel, Long> {
    
	PostModel findByUsername(String username);

    List<PostModel> findByUsernameIgnoreCase(String username);
    
    /*For searching posts*/
    @Query(value = "select * from posts p where p.postname like %:keyword% or p.category like %:keyword%",  nativeQuery = true)
    List<PostModel> findByKeyword(@Param("keyword") String keyword);
}
