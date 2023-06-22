package com.example.tutorials.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutorials.entity.SubjectEntity;
import com.example.tutorials.service.SubjectService;

@RestController
@RequestMapping("/api")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(value = "/addNewSubject", method = RequestMethod.POST)
	public SubjectEntity addSubject(@RequestBody SubjectEntity subjectEntity) {
		return subjectService.addNewSubject(subjectEntity);
	}
	
	@RequestMapping(value = "/viewAllSubjects", method = RequestMethod.GET)
	public List<SubjectEntity> readAllSubject(){
		return subjectService.getAllSubjects();
	}
	
	@RequestMapping(value = "/updateSubject/{id}", method = RequestMethod.PATCH)
	public SubjectEntity updateSubject(@PathVariable(value = "id") Integer id, @RequestBody SubjectEntity subjectEntity){
		return subjectService.updateSubjects(id, subjectEntity);
	}
	@RequestMapping(value = "/deleteSubject/{id}", method = RequestMethod.DELETE)
	public void deleteSubject(@PathVariable(value = "id") Integer id) {
		subjectService.deleteSubject(id);
	}
}
