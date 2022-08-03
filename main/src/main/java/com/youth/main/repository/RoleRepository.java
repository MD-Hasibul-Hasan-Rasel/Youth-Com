package com.youth.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youth.main.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	   
//	   @Query("SELECT u.email, u.password FROM user WHERE u.email = ?")
	   Role findByName(String name);
	   
	   
}
