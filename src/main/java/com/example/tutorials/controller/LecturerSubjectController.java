package com.example.tutorials.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.tutorials.dto.LecturerSubjectDto;
import com.example.tutorials.entity.LecturerSubjectsEntity;
import com.example.tutorials.entity.StudentEntity;
import com.example.tutorials.response.ResponseEntity;
import com.example.tutorials.service.LecturerSubjectService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LecturerSubjectController {

	@Autowired
    private LecturerSubjectService lecturerSubjectService;

    @RequestMapping(value = "/addLecturerSubject", method = RequestMethod.POST)
    public ResponseEntity addLecturerSubject(@RequestBody LecturerSubjectDto lecturerSubjectDTO) {
		LecturerSubjectsEntity lss= lecturerSubjectService.saveLecturerSubject(lecturerSubjectDTO);
    	try {
			ResponseEntity response = new ResponseEntity(true ,"Finding data success!", lss);
			return response;
    	} catch (Exception e) {
    		ResponseEntity response = new ResponseEntity(true ,"Finding data success!", lss);
			return response;		
		}
    }

	@RequestMapping(value = "/viewLecturerSubject", method = RequestMethod.GET)
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
//	@RequestMapping(value = "/lecturer-subject", method = RequestMethod.GET)
//    public List<LecturerSubjectsEntity> getAllLecSub() {
//        return lecturerSubjectService.getAllLecSub();
//    }
	
}
