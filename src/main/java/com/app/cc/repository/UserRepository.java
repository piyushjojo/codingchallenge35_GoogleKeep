package com.app.cc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.cc.entity.Users;



public interface UserRepository extends JpaRepository<Users, Long>{
	
	Users findByUsernameOrEmail(String username, String email);

}
