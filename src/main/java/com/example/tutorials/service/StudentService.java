package com.example.tutorials.service;

import java.util.List;

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
		se.setEmail(studentEntity.getEmail());
		se.setStatus_deleted(studentEntity.getStatus_deleted());
		se.setCreated_at(studentEntity.getCreated_at());
		se.setUpdated_at(studentEntity.getUpdated_at());
		
		return studentRepository.save(se);
	}
	
	//read all student
	public List<StudentEntity> getAllStudent(){
		return studentRepository.findAll();
	}
	
	//update a student data
	public StudentEntity updateStudent(Integer id, StudentEntity entity) 
	{
		StudentEntity se = studentRepository.findById(id).get();
		
		se.setFirst_name(entity.getFirst_name());
		se.setLast_name(entity.getLast_name());
		se.setEmail(entity.getEmail());
//		se.setStatus_deleted(entity.getStatus_deleted());
//		se.setCreated_at(entity.getCreated_at());
//		se.setUpdated_at(entity.getUpdated_at());
		
		return studentRepository.save(se);
	}
	
	//delete Student data
	public void deleteStudent(Integer id) {
		StudentEntity se = new StudentEntity();
		studentRepository.deleteById(id);

	}
	
}
