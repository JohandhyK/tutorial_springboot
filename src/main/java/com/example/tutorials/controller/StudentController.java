package com.example.tutorials.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutorials.entity.StudentEntity;
import com.example.tutorials.repository.StudentRepository;
import com.example.tutorials.response.ResponseEntity;
import com.example.tutorials.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/insert-data", method = RequestMethod.POST)
	public ResponseEntity<StudentEntity> addStudent(@Valid @RequestBody StudentEntity studentEntity, Errors errors) {
		if(errors.hasErrors()) {
			ResponseEntity<StudentEntity> responseEntity = new ResponseEntity<StudentEntity>("Failed", "Student fail to add");		
			return responseEntity;
		}
		StudentEntity se = studentService.addNewStudent(studentEntity);
		ResponseEntity<StudentEntity> responseEntity = new ResponseEntity<StudentEntity>("Success", "Student successfully added!", se);		
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StudentEntity>> readAllStudent(){
		List<StudentEntity> se = studentService.getAllStudent();
		ResponseEntity responseEntity = new ResponseEntity("Success","Data Found!", se);		
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentEntity> getDataById(@PathVariable Integer id) {
        // Retrieve data by ID from your data service
		Optional<StudentEntity> se = studentService.getDatabyId(id);

        if (se != null) {
    		ResponseEntity responseEntity = new ResponseEntity("Success","Data Found!", se);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity("Failed","Data not found",se);		
        	return responseEntity2;
        }
    }
        
    @RequestMapping(value = "/first_name/{first_name}" , method = RequestMethod.GET)
    public ResponseEntity<StudentEntity> getDataByName(@RequestParam("first_name") String first_name) {
    	List<StudentEntity> se = studentService.findByfirstname(first_name);
        if (se != null) {
    		ResponseEntity responseEntity = new ResponseEntity("Success","Data Found!", se);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity("Failed","Data not found",se);		
        	return responseEntity2;
        }
    }
    
    @RequestMapping(value = "/status" , method = RequestMethod.GET)
    public ResponseEntity<StudentEntity> getDataByStatus() {
    	List<StudentEntity> se = studentService.getAllByStatus();
        if (se != null) {
    		ResponseEntity responseEntity = new ResponseEntity("Success","Data Found!", se);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity("Failed","Data not found",se);		
        	return responseEntity2;
        }
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<StudentEntity> updateStudent(@Valid @PathVariable(value = "id") Integer id,@Valid @RequestBody StudentEntity entity, Errors errors){
		if(errors.hasErrors()) {
			ResponseEntity<StudentEntity> responseEntity = new ResponseEntity<StudentEntity>("Failed", "Student fail to updated");
			return responseEntity;	
		}
		StudentEntity se = studentService.updateStudent(id, entity);
		ResponseEntity<StudentEntity> responseEntity = new ResponseEntity<StudentEntity>("Success", "Student successfully updated!", se);		
		return responseEntity;	
	}
	
	//update status student aktif/nonaktif
	@RequestMapping(value = "/update-status/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<StudentEntity> updateStudentStatus(@PathVariable(value = "id") Integer id){
		StudentEntity se = studentService.updateStudentStatus(id);
		ResponseEntity<StudentEntity> responseEntity = new ResponseEntity<StudentEntity>("Success", "Student status successfully update!", se);		
		return responseEntity;	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteDataById(@PathVariable(value = "id") Integer id) {
		return "Student data successfully deleted with status " + studentService.deleteStudent(id);
	}
	
}
