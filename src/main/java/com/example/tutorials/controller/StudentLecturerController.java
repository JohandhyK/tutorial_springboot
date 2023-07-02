package com.example.tutorials.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutorials.dto.LecturerSubjectDto;
import com.example.tutorials.dto.StudentLecturerDto;
import com.example.tutorials.entity.LecturerSubjectsEntity;
import com.example.tutorials.entity.StudentLecturerEntity;
import com.example.tutorials.response.ResponseEntity;
import com.example.tutorials.service.LecturerSubjectService;
import com.example.tutorials.service.StudentLecturerService;

@RestController
@RequestMapping("/api/student-lecturer")
public class StudentLecturerController {
	
	@Autowired
    private StudentLecturerService studentLecturerService;

	//add data
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity addStudentLecturer(@RequestBody StudentLecturerDto studentLecturerDto) {
		StudentLecturerEntity lss= studentLecturerService.saveLecturerSubject(studentLecturerDto);
    	try {
			ResponseEntity<StudentLecturerEntity> response = new ResponseEntity<>(true ,"Data Successfully Added!", lss);
			return response;
    	} catch (Exception e) {
    		ResponseEntity<StudentLecturerEntity> response = new ResponseEntity<>(false ,"Parameter Limited!", lss);
			return response;		
		}
    }
    
    //tampilkan semua data di studlec_db
	@RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<StudentLecturerEntity>> readAllSudentLecturer() {
        List<StudentLecturerEntity> lecturerSubjects = studentLecturerService.getAllStudentLecturer();
        if(lecturerSubjects!= null) {
        	ResponseEntity responseEntity = new ResponseEntity(true ,"Finding data success!", lecturerSubjects);	
            return responseEntity;
        }else {
         	ResponseEntity responseEntity = new ResponseEntity(false ,"failed!", lecturerSubjects);	
            return responseEntity;
        }	
    }
	
	//membaca id dari id  
	@RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<StudentLecturerEntity>> getDataById(@PathVariable Integer id) {
      // Retrieve data by ID from your data service
		Optional<StudentLecturerEntity> se = studentLecturerService.getDatabyId(id);
//		List<StudentLecturerEntity> se = studentLecturerService.getDatabyLecId(lecturerId);
		if (se != null) {
    		ResponseEntity responseEntity = new ResponseEntity(true,"data successfully show!", se);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity(false,"Data not found",se);		
//        	return responseEntity2;
        }
	}
	
	//Read id dari lecturer id
	@RequestMapping(value = "/search/{lecturer_id}/lecturer", method = RequestMethod.GET)
	public ResponseEntity<List<StudentLecturerEntity>> findAllByLecturerId(@PathVariable("lecturer_id") Integer lecturer_id) {
      // Retrieve data by ID from your data service
		List<StudentLecturerEntity> se = studentLecturerService.findAllByLecturerId(lecturer_id);
		if (se != null) {
    		ResponseEntity responseEntity = new ResponseEntity(true,"data successfully show!", se);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity(false,"Data not found",se);		
        	return responseEntity2;
        }
	}
	
	//Read id dari student id
	@RequestMapping(value = "/search/{student_id}/student", method = RequestMethod.GET)
	public ResponseEntity<List<StudentLecturerEntity>> findAllByStudentId(@PathVariable("student_id") Integer student_id) {
      // Retrieve data by ID from your data service
		List<StudentLecturerEntity> se = studentLecturerService.findAllByStudentId(student_id);
		if (se != null) {
    		ResponseEntity responseEntity = new ResponseEntity(true,"data successfully show!", se);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity(false,"Data not found",se);		
        	return responseEntity2;
        }
	}
}
