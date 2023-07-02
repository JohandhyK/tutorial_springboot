package com.example.tutorials.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/api/lecturer-subject")
public class LecturerSubjectController {

	@Autowired
    private LecturerSubjectService lecturerSubjectService;

	//add data ke sub_lec_db
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity addLecturerSubject(@RequestBody LecturerSubjectDto lecturerSubjectDTO) {
		LecturerSubjectsEntity lss= lecturerSubjectService.saveLecturerSubject(lecturerSubjectDTO);
    	try {
			ResponseEntity response = new ResponseEntity(true ,"Data Success to Add!", lss);
			return response;
    	} catch (Exception e) {
    		ResponseEntity response = new ResponseEntity(false ,"Parameter data limited!", lss);
			return response;		
		}
    }

    //view all sub_lec_db
	@RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<LecturerSubjectsEntity>> readAllLecturerSubjects() {
        List<LecturerSubjectsEntity> lecturerSubjects = lecturerSubjectService.getAllLecturerSubjects();
        if(lecturerSubjects!= null) {
        	ResponseEntity responseEntity = new ResponseEntity(true ,"Finding data success!", lecturerSubjects);	
            return responseEntity;
        }else {
         	ResponseEntity responseEntity = new ResponseEntity(false ,"failed!", lecturerSubjects);	
            return responseEntity;
        }	
    }
	
	//Read id dari lecturer id
	@RequestMapping(value = "/search/{lecturer_id}/lecturer", method = RequestMethod.GET)
	public ResponseEntity<List<LecturerSubjectsEntity>> findAllByLecturerId(@PathVariable("lecturer_id") Integer lecturer_id) {
      // Retrieve data by ID from your data service
		List<LecturerSubjectsEntity> se = lecturerSubjectService.findAllByLecturerId(lecturer_id);
		if (se != null) {
    		ResponseEntity responseEntity = new ResponseEntity(true,"data successfully show!", se);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity(false,"Data not found",se);		
        	return responseEntity2;
        }
	}
	
	//Read id dari subject id
	@RequestMapping(value = "/search/{subject_id}/subject", method = RequestMethod.GET)
	public ResponseEntity<List<StudentLecturerEntity>> findAllBySubjectId(@PathVariable("subject_id") Integer subject_id) {
      // Retrieve data by ID from your data service
		List<LecturerSubjectsEntity> se = lecturerSubjectService.findAllBySubjectId(subject_id);
		if (se != null) {
    		ResponseEntity responseEntity = new ResponseEntity(true,"data successfully show!", se);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity(false,"Data not found",se);		
        	return responseEntity2;
        }
	}
	
	@RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<StudentLecturerEntity>> getDataById(@PathVariable Integer id) {
      // Retrieve data by ID from your data service
		Optional<LecturerSubjectsEntity> se = lecturerSubjectService.getDatabyId(id);
//		List<StudentLecturerEntity> se = studentLecturerService.getDatabyLecId(lecturerId);
		if (se != null) {
    		ResponseEntity responseEntity = new ResponseEntity(true,"data successfully show!", se);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity(false,"Data not found",se);		
        	return responseEntity2;
        }
	}
		
}
