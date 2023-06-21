package com.example.tutorials.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/addNewStudent", method = RequestMethod.POST)
	public StudentEntity addStudent(@RequestBody StudentEntity studentEntity) {
		return studentService.addNewStudent(studentEntity);
	}
	
	@RequestMapping(value = "/viewAllStudent", method = RequestMethod.GET)
	public List<StudentEntity> readAllStudent(){
		return studentService.getAllStudent();
	}
	
	@RequestMapping(value = "/updateStudent/{id}", method = RequestMethod.PATCH)
	public StudentEntity updateStudent(@PathVariable(value = "id") Integer id, @RequestBody StudentEntity entity){
		
		return studentService.updateStudent(id, entity);
	}
	@RequestMapping(value = "/deleteStudent/{id}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable(value = "id") Integer id) {
		studentService.deleteStudent(id);
	}
	
}
