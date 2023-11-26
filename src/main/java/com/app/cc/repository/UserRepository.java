package com.app.cc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.cc.entity.Users;
import java.util.List;




public interface UserRepository extends JpaRepository<Users, Long>{
	
	Users findByUsernameOrEmail(String username, String email);
	
	Users findByUserid(Long userid);

}
