package com.example.tutorials.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.example.tutorials.dto.LecturerSubjectDto;
import com.example.tutorials.entity.LecturerSubjectsEntity;
import com.example.tutorials.entity.StudentCitiesEntity;
import com.example.tutorials.entity.StudentEntity;
import com.example.tutorials.entity.StudentLecturerEntity;
import com.example.tutorials.entity.SubjectEntity;
import com.example.tutorials.response.ResponseEntity;
import com.example.tutorials.service.LecturerSubjectService;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/lecturers-subjects")
public class LecturerSubjectController {

	@Autowired
    private LecturerSubjectService lecturerSubjectService;

	//add data ke sub_lec_db
    @RequestMapping(value = "/insert-data", method = RequestMethod.POST)
    public ResponseEntity addLecturerSubject(@Valid @RequestBody LecturerSubjectDto lecturerSubjectDTO, Errors errors) {
		if(errors.hasErrors()) {
    		ResponseEntity response = new ResponseEntity("Failed","Parameter data limited!");
			return response;
		}
    	LecturerSubjectsEntity lss= lecturerSubjectService.saveLecturerSubject(lecturerSubjectDTO);
		ResponseEntity response = new ResponseEntity("Success","Data Success to Add!", lss);
		return response;
    }

    //view all sub_lec_db
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<LecturerSubjectsEntity>> readAllLecturerSubjects() {
        List<LecturerSubjectsEntity> lecturerSubjects = lecturerSubjectService.getAllLecturerSubjects();
        if(lecturerSubjects!= null) {
        	ResponseEntity responseEntity = new ResponseEntity("Success" ,"Data Found!", lecturerSubjects);	
            return responseEntity;
        }else {
         	ResponseEntity responseEntity = new ResponseEntity("Failed" ,"No Data Found!", lecturerSubjects);	
            return responseEntity;
        }	
    }
	
	//Read id dari lecturer id
	@RequestMapping(value = "/lecturers/{lecturer_id}/subjects", method = RequestMethod.GET)
	public ResponseEntity<List<LecturerSubjectsEntity>> findAllByLecturerId(@PathVariable("lecturer_id") Integer lecturer_id) {
      // Retrieve data by ID from your data service
		List<LecturerSubjectsEntity> se = lecturerSubjectService.findAllByLecturerId(lecturer_id);
		if (se != null) {
    		ResponseEntity responseEntity = new ResponseEntity("Success","data Found!", se);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity("Failed","Data not found",se);		
        	return responseEntity2;
        }
	}
	
	//Read id dari subject id
	@RequestMapping(value = "/subject/{subject_id}/lecturers", method = RequestMethod.GET)
	public ResponseEntity<List<StudentLecturerEntity>> findAllBySubjectId(@PathVariable("subject_id") Integer subject_id) {
      // Retrieve data by ID from your data service
		List<LecturerSubjectsEntity> se = lecturerSubjectService.findAllBySubjectId(subject_id);
		if (se != null) {
    		ResponseEntity responseEntity = new ResponseEntity("Success","data Found!", se);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity("Failed","Data not found",se);		
        	return responseEntity2;
        }
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<StudentLecturerEntity>> getDataById(@PathVariable Integer id) {
      // Retrieve data by ID from your data service
		Optional<LecturerSubjectsEntity> se = lecturerSubjectService.getDatabyId(id);
//		List<StudentLecturerEntity> se = studentLecturerService.getDatabyLecId(lecturerId);
		if (se != null) {
    		ResponseEntity responseEntity = new ResponseEntity("Success","Data Found!", se);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity("False","Data not found",se);		
        	return responseEntity2;
        }
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteDataById(@PathVariable(value = "id") Integer id) {
		return "Lecturer-Student data successfully deleted with status " + lecturerSubjectService.deleteDataById(id);
	}
	
}
