package com.app.cc.repository;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.app.cc.entity.NoteEntity;
import com.app.cc.entity.Users;


@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {
	
	@Autowired
	private NotesRepository notesRepo ; 
	
	@Autowired
	private UserRepository userRepo ; 
	
	@Test
	@Order(1)
	public void can_create_user() {
		Users user = new Users();
		user.setUsername("test user");
		user.setEmail("testuser@log.com");
		user.setPassword("testpassword");
		userRepo.save(user);
	}

	
}
