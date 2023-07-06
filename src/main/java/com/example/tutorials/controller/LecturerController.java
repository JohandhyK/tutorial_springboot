package com.example.tutorials.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Error;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutorials.entity.LecturerEntity;
import com.example.tutorials.entity.StudentEntity;
import com.example.tutorials.entity.SubjectEntity;
import com.example.tutorials.response.ResponseEntity;
import com.example.tutorials.service.LecturerService;

@RestController
@RequestMapping("/api/lecturers")
public class LecturerController {
	
	@Autowired
	private LecturerService lecturerService;
	
	@RequestMapping(value = "/insert-data", method = RequestMethod.POST)
	public ResponseEntity<LecturerEntity> addLecturer(@Valid @RequestBody LecturerEntity lecturerEntity, Errors errors) {
		if(errors.hasErrors()) {
			ResponseEntity<LecturerEntity> responseEntity = new ResponseEntity<LecturerEntity>("Failed", "Lecturer fail to add");		
			return responseEntity;
		}
		LecturerEntity le = lecturerService.addNewLecturer(lecturerEntity);
		ResponseEntity<LecturerEntity> responseEntity = new ResponseEntity<LecturerEntity>("Success", "Lecturer successfully added!", le);		
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LecturerEntity>> readAllLecturer(){
		List<LecturerEntity> le = lecturerService.getAllLecturer();
		ResponseEntity responseEntity = new ResponseEntity("Success", "Data Found!", le);		
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<LecturerEntity> updateLecturer(@Valid @PathVariable(value = "id") Integer id, @Valid @RequestBody LecturerEntity lecturerEntity, Errors errors){	
		if(errors.hasErrors()) {
			ResponseEntity<LecturerEntity> responseEntity = new ResponseEntity<LecturerEntity>("Failed", "Lecturer fail to updated!");		
			return responseEntity;
		}
		LecturerEntity le = lecturerService.updateLecturer(id, lecturerEntity);
		ResponseEntity<LecturerEntity> responseEntity = new ResponseEntity<LecturerEntity>("Success", "Lecturer successfully updated!", le);		
		return responseEntity;
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<LecturerEntity> getDataById(@PathVariable Integer id) {
        // Retrieve data by ID from your data service
		Optional<LecturerEntity> se = lecturerService.getDatabyId(id);
        if (se != null) {
    		ResponseEntity responseEntity = new ResponseEntity("Success","Data Found!", se);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity("Failed","Data not found",se);		
        	return responseEntity2;
        }
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteDataById(@PathVariable(value = "id") Integer id) {
		return "Lecturer data successfully deleted with status " + lecturerService.deleteLecturer(id);
	}
	
	@RequestMapping(value = "/update-status/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<LecturerEntity> updateLecturerStatus(@PathVariable(value = "id") Integer id){
		LecturerEntity se = lecturerService.updateLecturerStatus(id);
		ResponseEntity<LecturerEntity> responseEntity = new ResponseEntity<LecturerEntity>("Success", "Lecturer status successfully updated!", se);		
		return responseEntity;	
	}
	
}