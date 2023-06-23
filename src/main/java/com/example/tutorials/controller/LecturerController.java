package com.example.tutorials.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutorials.entity.LecturerEntity;
import com.example.tutorials.entity.StudentEntity;
import com.example.tutorials.response.ResponseEntity;
import com.example.tutorials.service.LecturerService;

@RestController
@RequestMapping("/api")
public class LecturerController {
	
	@Autowired
	private LecturerService lecturerService;
	
	@RequestMapping(value = "/addNewLecturer", method = RequestMethod.POST)
	public ResponseEntity<LecturerEntity> addLecturer(@RequestBody LecturerEntity lecturerEntity) {
		LecturerEntity le = lecturerService.addNewLecturer(lecturerEntity);
		ResponseEntity<LecturerEntity> responseEntity = new ResponseEntity<LecturerEntity>(true, "Lecturer successfully added!", le);		
		return responseEntity;
	}
	
	@RequestMapping(value = "/viewAllLecturers", method = RequestMethod.GET)
	public ResponseEntity<List<LecturerEntity>> readAllLecturer(){
		List<LecturerEntity> le = lecturerService.getAllLecturer();
		ResponseEntity responseEntity = new ResponseEntity(true, "Lecturer successfully added!", le);		
		return responseEntity;
	}
	
	@RequestMapping(value = "/updateLecturer/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<LecturerEntity> updateLecturer(@PathVariable(value = "id") Integer id, @RequestBody LecturerEntity lecturerEntity){	
		LecturerEntity le = lecturerService.updateLecturer(id, lecturerEntity);
		ResponseEntity<LecturerEntity> responseEntity = new ResponseEntity<LecturerEntity>(true, "Lecturer successfully added!", le);		
		return responseEntity;
		
	}
	@RequestMapping(value = "/deleteLecturer/{id}", method = RequestMethod.DELETE)
	public void deleteLecturer(@PathVariable(value = "id") Integer id) {
		lecturerService.deleteLecturer(id);
	}
}