package com.example.tutorials.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tutorials.entity.SubjectEntity;
import com.example.tutorials.repository.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	//add new subject
	public SubjectEntity addNewSubject(SubjectEntity subjectEntity) {
		SubjectEntity se = new SubjectEntity();
		se.setName(subjectEntity.getName());
		se.setDescription(subjectEntity.getDescription());
		se.setStatus_deleted(false);
		se.setCreated_at(subjectEntity.getCreated_at());
		se.setUpdated_at(subjectEntity.getUpdated_at());
		
		return subjectRepository.save(se);
	}
	
	//read all subjects
	public List<SubjectEntity> getAllSubjects(){
		return subjectRepository.findAll();
	}
	
	//update a student data
	public SubjectEntity updateSubjects(Integer id, SubjectEntity lecturer) 
	{
		SubjectEntity se = subjectRepository.findById(id).get();
		se.setName(lecturer.getName());
		se.setDescription(lecturer.getDescription());
//		le.setUpdated_at(lecturer.getUpdated_at());

		return subjectRepository.save(se);
	}
	
	//delete Student data
	public void deleteSubject(Integer id) {
		SubjectEntity se = new SubjectEntity();
		subjectRepository.deleteById(id);

	}

}
