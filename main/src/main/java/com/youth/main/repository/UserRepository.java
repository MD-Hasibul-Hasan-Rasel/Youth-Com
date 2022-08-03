package com.youth.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.youth.main.model.UserModel;

@Repository
public interface UserRepository 
       extends JpaRepository<UserModel, Long> {
   
//   @Query("SELECT u FROM User u WHERE u.email = ?1")
   UserModel findByUsername(String username);
}
