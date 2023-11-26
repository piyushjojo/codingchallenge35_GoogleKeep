package com.app.cc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cc.entity.NoteEntity;
import com.app.cc.entity.Users;
import com.app.cc.repository.NotesRepository;

@Service
public class NotesService {
	
	@Autowired 
	private NotesRepository notesRepo ; 
	
	@Autowired
	private UserService userService ; 
	
	public NoteEntity addNotes(String title, String content, long userId) {
		
		Users u = userService.getUserById(userId);
		if(u == null) {
			return null;
		}
		
		NoteEntity note = new NoteEntity(); 
		note.setTitle(title);
		note.setContent(content);
		note.setUserid(userId);
		
		notesRepo.save(note);
		return note;
	}
	
	public List<NoteEntity> getAllNotes(Long userId){
		Users u = userService.getUserById(userId);
		if(u == null) {
			return null;
		}
		
		List<NoteEntity> notesList = notesRepo.findByUserid(u.getUserid());
		return notesList;
	}
	
	public NoteEntity getNoteById(Long noteid, Long userid) {
		Users u = userService.getUserById(userid);
		if(u == null) {
			return null;
		}
		
		NoteEntity note = notesRepo.findByIdAndUserid(noteid,userid);
		if(note == null) {
			return null;
		}
		return note;
	}
}
