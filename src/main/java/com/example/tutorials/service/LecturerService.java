package com.example.tutorials.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tutorials.entity.LecturerEntity;
import com.example.tutorials.entity.StudentEntity;
import com.example.tutorials.entity.SubjectEntity;
import com.example.tutorials.repository.LecturerRepository;
import com.example.tutorials.repository.StudentRepository;
import com.example.tutorials.response.ResponseEntity;

@Service
public class LecturerService {
	
	@Autowired
	private LecturerRepository lecturerRepository;
	
	//add new lecturer
	public LecturerEntity addNewLecturer(LecturerEntity lecturerEntity) {
		if(lecturerEntity.getName() == null && lecturerEntity.getTitle() == null) {
            throw new IllegalArgumentException("Name and division must not be null");
		}else {
			LecturerEntity le = new LecturerEntity();
			le.setName(lecturerEntity.getName());
			le.setTitle(lecturerEntity.getTitle());
			le.setStatus(true);
			le.setCreated_at(lecturerEntity.getCreated_at());
			le.setUpdated_at(lecturerEntity.getUpdated_at());
			return lecturerRepository.save(le);		
		}
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
		le.setUpdated_at(lecturer.getUpdated_at());

		return lecturerRepository.save(le);
	}
	
	public LecturerEntity updateLecturerStatus(Integer id) 
	{
		LecturerEntity se = lecturerRepository.findById(id).get();
		if(se.getStatus() == false) {
			se.setStatus(true);	
		}else {
			se.setStatus(false);	
		}
		return lecturerRepository.save(se);
	}
	
	//delete lecturer data
	public Integer deleteLecturer(Integer id) {
		return lecturerRepository.deleteDataById(id);
	}

}
