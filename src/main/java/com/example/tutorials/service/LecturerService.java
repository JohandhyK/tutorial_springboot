package com.example.tutorials.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tutorials.entity.LecturerEntity;
import com.example.tutorials.entity.StudentEntity;
import com.example.tutorials.repository.LecturerRepository;
import com.example.tutorials.repository.StudentRepository;

@Service
public class LecturerService {
	
	@Autowired
	private LecturerRepository lecturerRepository;
	
	//add new lecturer
	public LecturerEntity addNewLecturer(LecturerEntity lecturerEntity) {
		LecturerEntity le = new LecturerEntity();
		le.setName(lecturerEntity.getName());
		le.setTitle(lecturerEntity.getTitle());
		le.setStatus_deleted(false);
		le.setCreated_at(lecturerEntity.getCreated_at());
		le.setUpdated_at(lecturerEntity.getUpdated_at());
		return lecturerRepository.save(le);
	}
	
	//read all lecturer
	public List<LecturerEntity> getAllLecturer(){
		return lecturerRepository.findAll();
	}
	
	//update a lecturer data
	public LecturerEntity updateLecturer(Integer id, LecturerEntity lecturer) 
	{
		LecturerEntity le = lecturerRepository.findById(id).get();
		le.setName(lecturer.getName());
		le.setTitle(lecturer.getTitle());
//		le.setUpdated_at(lecturer.getUpdated_at());

		return lecturerRepository.save(le);
	}
	
	//delete lecturer data
	public void deleteLecturer(Integer id) {
		LecturerEntity le = new LecturerEntity();
		lecturerRepository.deleteById(id);

	}
	
}
