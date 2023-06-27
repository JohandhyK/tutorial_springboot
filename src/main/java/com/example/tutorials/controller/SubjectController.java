package com.example.tutorials.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(value = "/addNewSubject", method = RequestMethod.POST)
	public ResponseEntity<SubjectEntity> addSubject(@RequestBody SubjectEntity subjectEntity) {
		SubjectEntity se = subjectService.addNewSubject(subjectEntity);
		ResponseEntity<SubjectEntity> responseEntity = new ResponseEntity<SubjectEntity>(true, "Subject successfully added!", se);		
		return responseEntity;
	}
	
	@RequestMapping(value = "/viewAllSubjects", method = RequestMethod.GET)
	public ResponseEntity<List<SubjectEntity>>readAllSubject(){
		List<SubjectEntity> se = subjectService.getAllSubjects();
		ResponseEntity responseEntity = new ResponseEntity(true, "Subject successfully added!", se);		
		return responseEntity;
	}
	
	@RequestMapping(value = "/updateSubject/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<SubjectEntity> updateSubject(@PathVariable(value = "id") Integer id, @RequestBody SubjectEntity subjectEntity){
		SubjectEntity se = subjectService.updateSubjects(id, subjectEntity);
		ResponseEntity<SubjectEntity> responseEntity = new ResponseEntity<SubjectEntity>(true, "Subject successfully added!", se);		
		return responseEntity;
	}
	
	@RequestMapping(value = "/deleteSubject/{id}", method = RequestMethod.DELETE)
	public void deleteSubject(@PathVariable(value = "id") Integer id) {
		subjectService.deleteSubject(id);
	}
	
	//update status subject aktif/nonaktif
	@RequestMapping(value = "/updateSubjectStatus/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<SubjectEntity> updateSubjectStatus(@PathVariable(value = "id") Integer id){
		SubjectEntity se = subjectService.updateSubjectStatus(id);
		ResponseEntity<SubjectEntity> responseEntity = new ResponseEntity<SubjectEntity>(true, "Subject status successfully update!", se);		
		return responseEntity;	
	}
	
}
