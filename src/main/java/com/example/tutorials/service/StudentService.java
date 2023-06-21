package com.example.tutorials.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tutorials.entity.StudentEntity;
import com.example.tutorials.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	
	//add new student
	public StudentEntity addNewStudent(StudentEntity studentEntity) {
		StudentEntity se = new StudentEntity();
		se.setFirst_name(studentEntity.getFirst_name());
		se.setLast_name(studentEntity.getLast_name());
		
		return studentRepository.save(se);
	}

	
}
