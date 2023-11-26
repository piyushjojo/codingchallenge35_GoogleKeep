package com.app.cc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.cc.entity.NoteEntity;

@Repository
public interface NotesRepository extends JpaRepository<NoteEntity, Long>{

	List<NoteEntity> findByUserid(Long userid);
	
	NoteEntity findByIdAndUserid(Long id, Long userid);
}
