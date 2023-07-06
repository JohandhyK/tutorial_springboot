package com.example.tutorials.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
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
@RequestMapping("/api/students-cities")
public class StudentCitiesController {

	@Autowired
    private StudentCitiesService studentCitiesService;

	public StudentCitiesEntity checkDuplicates(StudentCitiesDTO citiesDTO) {
		
		
		return null;
	}
	
	//add data ke sub_lec_db
    @RequestMapping(value = "/insert-data", method = RequestMethod.POST)
    public ResponseEntity addStudentCities(@Valid @RequestBody StudentCitiesDTO studentCitiesDTO, Errors errors) {
    	if(errors.hasErrors()) {
    		ResponseEntity response = new ResponseEntity("Failed" ,"Parameter data limited!");
			return response;			
    	}
		StudentCitiesEntity sce= studentCitiesService.saveStudentCities(studentCitiesDTO);
		if(sce == null) {
			ResponseEntity response = new ResponseEntity("Failed" ,"Data is empty to add!");
			return response;	
		}
		
		ResponseEntity response = new ResponseEntity("Success" ,"Data Added!", sce);
		return response;
    }

    //view all sub_lec_db
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<StudentCitiesEntity>> readAllLStudentCities() {
        List<StudentCitiesEntity> sce = studentCitiesService.getAllLecturerSubjects();
        if(sce!= null) {
        	ResponseEntity responseEntity = new ResponseEntity("Success" ,"Data Found!", sce);	
            return responseEntity;
        }else {
         	ResponseEntity responseEntity = new ResponseEntity("Failed" ,"No Data Foudnd!", sce);	
            return responseEntity;
        }	
    }
	
	//Read id dari lecturer id
	@RequestMapping(value = "/students/{student_id}/cities", method = RequestMethod.GET)
	public ResponseEntity<List<StudentCitiesEntity>> findAllByStudentId(@PathVariable("student_id") Integer student_id) {
      // Retrieve data by ID from your data service
		List<StudentCitiesEntity> sce = studentCitiesService.findAllByStudentId(student_id);
		if (sce != null) {
    		ResponseEntity responseEntity = new ResponseEntity("Success","Data Found!", sce);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity("Failed","Data not found",sce);		
        	return responseEntity2;
        }
	}
	
	//Read id dari subject id
	@RequestMapping(value = "/cities/{cities_id}/students", method = RequestMethod.GET)
	public ResponseEntity<List<StudentCitiesEntity>> findAllByCitiesId(@PathVariable("cities_id") Integer cities_id) {
      // Retrieve data by ID from your data service
		List<StudentCitiesEntity> sce = studentCitiesService.findAllByCitiesId(cities_id);
		if (sce != null) {
    		ResponseEntity responseEntity = new ResponseEntity("Success","Data Found!", sce);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity("Failed","Data not found",sce);		
        	return responseEntity2;
        }
	}
	
	//membaca id dari id  
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<StudentCitiesEntity>> getDataById(@PathVariable Integer id) {
      // Retrieve data by ID from your data service
		Optional<StudentCitiesEntity> se = studentCitiesService.getDatabyId(id);
//		List<StudentLecturerEntity> se = studentLecturerService.getDatabyLecId(lecturerId);
		if (se != null) {
    		ResponseEntity responseEntity = new ResponseEntity("Success","Data Show!", se);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity("Failed","Data not found",se);		
        	return responseEntity2;
        }
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteDataById(@PathVariable(value = "id") Integer id) {
		return "Student-Cities data successfully deleted with status " + studentCitiesService.deleteDataById(id);
	}
}
