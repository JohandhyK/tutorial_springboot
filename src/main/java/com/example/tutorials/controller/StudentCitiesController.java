package com.example.tutorials.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutorials.dto.LecturerSubjectDto;
import com.example.tutorials.dto.StudentCitiesDTO;
import com.example.tutorials.entity.LecturerSubjectsEntity;
import com.example.tutorials.entity.StudentCitiesEntity;
import com.example.tutorials.entity.StudentLecturerEntity;
import com.example.tutorials.response.ResponseEntity;
import com.example.tutorials.service.LecturerSubjectService;
import com.example.tutorials.service.StudentCitiesService;

@RestController
@RequestMapping("/api/student-cities")
public class StudentCitiesController {

	@Autowired
    private StudentCitiesService studentCitiesService;

	//add data ke sub_lec_db
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity addStudentCities(@RequestBody StudentCitiesDTO studentCitiesDTO) {
		StudentCitiesEntity sce= studentCitiesService.saveStudentCities(studentCitiesDTO);
    	try {
			ResponseEntity response = new ResponseEntity(true ,"Data Success to Add!", sce);
			return response;
    	} catch (Exception e) {
    		ResponseEntity response = new ResponseEntity(false ,"Parameter data limited!", sce);
			return response;		
		}
    }

    //view all sub_lec_db
	@RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<StudentCitiesEntity>> readAllLStudentCities() {
        List<StudentCitiesEntity> sce = studentCitiesService.getAllLecturerSubjects();
        if(sce!= null) {
        	ResponseEntity responseEntity = new ResponseEntity(true ,"Finding data success!", sce);	
            return responseEntity;
        }else {
         	ResponseEntity responseEntity = new ResponseEntity(false ,"failed!", sce);	
            return responseEntity;
        }	
    }
	
	//Read id dari lecturer id
	@RequestMapping(value = "/search/{student_id}/student", method = RequestMethod.GET)
	public ResponseEntity<List<StudentCitiesEntity>> findAllByStudentId(@PathVariable("student_id") Integer student_id) {
      // Retrieve data by ID from your data service
		List<StudentCitiesEntity> sce = studentCitiesService.findAllByStudentId(student_id);
		if (sce != null) {
    		ResponseEntity responseEntity = new ResponseEntity(true,"data successfully show!", sce);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity(false,"Data not found",sce);		
        	return responseEntity2;
        }
	}
	
	//Read id dari subject id
	@RequestMapping(value = "/search/{cities_id}/cities", method = RequestMethod.GET)
	public ResponseEntity<List<StudentCitiesEntity>> findAllByCitiesId(@PathVariable("cities_id") Integer cities_id) {
      // Retrieve data by ID from your data service
		List<StudentCitiesEntity> sce = studentCitiesService.findAllByCitiesId(cities_id);
		if (sce != null) {
    		ResponseEntity responseEntity = new ResponseEntity(true,"data successfully show!", sce);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity(false,"Data not found",sce);		
        	return responseEntity2;
        }
	}
	
	//membaca id dari id  
	@RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<StudentCitiesEntity>> getDataById(@PathVariable Integer id) {
      // Retrieve data by ID from your data service
		Optional<StudentCitiesEntity> se = studentCitiesService.getDatabyId(id);
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
