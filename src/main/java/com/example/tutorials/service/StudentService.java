package com.example.tutorials.service;

import java.util.List;
import java.util.Optional;

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
		se.setStatus(studentEntity.getStatus());
		se.setCreated_at(studentEntity.getCreated_at());
		se.setUpdated_at(studentEntity.getUpdated_at());
		
		return studentRepository.save(se);
	}
	
	//read all student
	public List<StudentEntity> getAllStudent(){
		return studentRepository.findAll();
	}
	
	public Optional<StudentEntity> getDatabyId(Integer id) {
        // Retrieve data by ID from your data service
        StudentEntity se = studentRepository.findById(id).get();
        return studentRepository.findById(id);

	}
	//find by name
	public List<StudentEntity> findByfirstname(String first_name) {
		return  studentRepository.findByfirstname(first_name);
	}
	
	//update a student data
	public StudentEntity updateStudent(Integer id, StudentEntity entity) 
	{
		StudentEntity se = studentRepository.findById(id).get();
		
		se.setFirst_name(entity.getFirst_name());
		se.setLast_name(entity.getLast_name());
		se.setEmail(entity.getEmail());
		se.setUpdated_at(entity.getUpdated_at());

		return studentRepository.save(se);
	}
	
	//update student status
	public StudentEntity updateStudentStatus(Integer id) 
	{
		StudentEntity se = studentRepository.findById(id).get();
		if(se.getStatus() == false) {
			se.setStatus(true);	
		}else {
			se.setStatus(false);	
		}
		se.setUpdated_at(se.getUpdated_at());

		return studentRepository.save(se);
	}
	
	//delete Student data
	public void deleteStudent(Integer id) {
		StudentEntity deleted = new StudentEntity();
		studentRepository.deleteById(id);

	}
	
	public StudentEntity defaultStatus(Integer id) {
		StudentEntity se = studentRepository.findById(id).get();
		return null;
	}
	
}
