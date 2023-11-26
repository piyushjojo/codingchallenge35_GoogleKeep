package com.app.cc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.cc.dto.UserRegistrationDTO;
import com.app.cc.entity.Users;
import com.app.cc.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService ; 
	
	@PostMapping
	public ResponseEntity<?> register(@RequestBody UserRegistrationDTO body){
		Users user = userService.getUserByUsernameOrEmail(body.getUsername(), body.getEmail());
		if(user != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Username or email is already registered.");
		}
		user = userService.register(body.getUsername(), body.getEmail(), body.getPassword());
		return ResponseEntity.ok(user);
	}
}
