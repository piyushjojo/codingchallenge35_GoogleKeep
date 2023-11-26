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
public class NotesRepositoryTest {
	
	@Autowired
	private NotesRepository notesRepo ; 
	
	@Autowired
	private UserRepository userRepo ; 

	@Test
	@Order(1)
	public void can_create_note() {
		Users user = new Users();
		user.setUsername("test user");
		user.setEmail("testuser@log.com");
		user.setPassword("testpassword");
		userRepo.save(user);
		
		NoteEntity note = new NoteEntity();
		note.setTitle("test title");
		note.setContent("test content,,,,,,,,,,,");
		note.setUserid(user.getUserid());
		
		notesRepo.save(note);
	}
	
	
}
