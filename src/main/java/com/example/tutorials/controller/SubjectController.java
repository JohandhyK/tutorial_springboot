package com.example.tutorials.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutorials.entity.StudentEntity;
import com.example.tutorials.entity.SubjectEntity;
import com.example.tutorials.response.ResponseEntity;
import com.example.tutorials.service.SubjectService;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(value = "/insert-data", method = RequestMethod.POST)
	public ResponseEntity<SubjectEntity> addSubject(@Valid @RequestBody SubjectEntity subjectEntity, Errors errors) {
		if(errors.hasErrors()) {
			ResponseEntity<SubjectEntity> responseEntity = new ResponseEntity<SubjectEntity>("Failed", "Subject failed to add!");		
			return responseEntity;	
		}
		SubjectEntity se = subjectService.addNewSubject(subjectEntity);
		ResponseEntity<SubjectEntity> responseEntity = new ResponseEntity<SubjectEntity>("Success", "Subject successfully added!", se);		
		return responseEntity;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<SubjectEntity>>readAllSubject(){
		List<SubjectEntity> se = subjectService.getAllSubjects();
		ResponseEntity responseEntity = new ResponseEntity("Success", "Data Found!", se);		
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<SubjectEntity> updateSubject(@Valid @PathVariable(value = "id") Integer id,@Valid @RequestBody SubjectEntity subjectEntity, Errors errors){
		if(errors.hasErrors()) {
			ResponseEntity<SubjectEntity> responseEntity = new ResponseEntity<SubjectEntity>("Failed", "Subject fail to updated!");		
			return responseEntity;
		}
		SubjectEntity se = subjectService.updateSubjects(id, subjectEntity);
		ResponseEntity<SubjectEntity> responseEntity = new ResponseEntity<SubjectEntity>("Success", "Subject successfully updated!", se);		
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteDataById(@PathVariable(value = "id") Integer id) {
		return "Subject data successfully dleleted with status " + subjectService.deleteDataById(id);
	}
	
	//update status subject aktif/nonaktif
	@RequestMapping(value = "/update-status/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<SubjectEntity> updateSubjectStatus(@PathVariable(value = "id") Integer id){
		SubjectEntity se = subjectService.updateSubjectStatus(id);
		ResponseEntity<SubjectEntity> responseEntity = new ResponseEntity<SubjectEntity>("Success", "Subject status successfully update!", se);		
		return responseEntity;	
	}
	
}
