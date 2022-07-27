package com.youth.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.youth.main.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
