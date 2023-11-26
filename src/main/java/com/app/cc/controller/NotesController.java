package com.app.cc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.cc.dto.NotesDTO;
import com.app.cc.entity.NoteEntity;
import com.app.cc.service.NotesService;

@RestController
@RequestMapping("/users/{id}/notes")
public class NotesController {

	@Autowired
	private NotesService notesService;

	@PostMapping
	public ResponseEntity<?> addNotes(@PathVariable("id") Integer id, @RequestBody NotesDTO body) {
		NoteEntity note = notesService.addNotes(body.getTitle(), body.getContent(), id);
		if (note == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(note);
	}

	@GetMapping
	public ResponseEntity<?> getAllNotes(@PathVariable("id") Long id) {
		List<NoteEntity> notes = notesService.getAllNotes(id);
		if (notes == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(notes);
	}
	
	@GetMapping({"/{noteid}"})
	public ResponseEntity<?> getNoteById(@PathVariable("noteid") Long noteId, @PathVariable("id") Long userId){
		NoteEntity note = notesService.getNoteById(noteId, userId);
		if (note == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(note);
	}
}
