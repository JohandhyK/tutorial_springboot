package com.example.tutorials.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutorials.entity.StudentEntity;
import com.example.tutorials.response.ResponseEntity;
import com.example.tutorials.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/addNewStudent", method = RequestMethod.POST)
	public ResponseEntity<StudentEntity> addStudent(@RequestBody StudentEntity studentEntity) {
		StudentEntity se = studentService.addNewStudent(studentEntity);
		ResponseEntity<StudentEntity> responseEntity = new ResponseEntity<StudentEntity>(true, "Student successfully added!", se);		
		return responseEntity;
	}
	
	@RequestMapping(value = "/viewAllStudents", method = RequestMethod.GET)
	public ResponseEntity<List<StudentEntity>> readAllStudent(){
		List<StudentEntity> se = studentService.getAllStudent();
		ResponseEntity responseEntity = new ResponseEntity(true,"data successfully show!", se);		
		return responseEntity;
	}
	
	@RequestMapping(value = "/updateStudent/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<StudentEntity> updateStudent(@PathVariable(value = "id") Integer id, @RequestBody StudentEntity entity){
		StudentEntity se = studentService.updateStudent(id, entity);
		ResponseEntity<StudentEntity> responseEntity = new ResponseEntity<StudentEntity>(true, "Student successfully update!", se);		
		return responseEntity;	
	}
	
	@RequestMapping(value = "/deleteStudent/{id}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable(value = "id") Integer id) {
		studentService.deleteStudent(id);
	}
	
}
