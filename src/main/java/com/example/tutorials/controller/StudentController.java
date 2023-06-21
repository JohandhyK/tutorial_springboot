package com.example.tutorials.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutorials.entity.StudentEntity;
import com.example.tutorials.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/addNewStudent")
	public StudentEntity addStudent(@RequestBody StudentEntity studentEntity) {
		return studentService.addNewStudent(studentEntity);
	}
	
	@RequestMapping(value = "/viewAllStudent")
	public List<StudentEntity> readAllStudent(){
		return studentService.getAllStudent();
	}
	
}
