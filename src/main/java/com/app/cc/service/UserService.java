package com.app.cc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cc.entity.Users;
import com.app.cc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public Users register(String username, String email, String password) {
		Users user = getUserByUsernameOrEmail(username, email);
		if (user == null) {
			user = new Users();
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(password);
		}
		userRepo.save(user);
		return user;
	}
	
	public Users getUserByUsernameOrEmail(String username , String email) {
		Users user = userRepo.findByUsernameOrEmail(username, email);
		return user;
	}
	
	public Users getUserById(long id) {
		return userRepo.findByUserid(id);
		
	}

}
