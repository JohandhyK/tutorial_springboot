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
@RequestMapping("/api/students-lecturers")
public class StudentLecturerController {
	
	@Autowired
    private StudentLecturerService studentLecturerService;

	//add data
    @RequestMapping(value = "/insert-data", method = RequestMethod.POST)
    public ResponseEntity addStudentLecturer(@Valid @RequestBody StudentLecturerDto studentLecturerDto, Errors errors) {
		if(errors.hasErrors()) {
    		ResponseEntity<StudentLecturerEntity> response = new ResponseEntity<>("Failed" ,"Parameter Data Limited!");
			return response;		
		}
    	StudentLecturerEntity lss= studentLecturerService.saveLecturerSubject(studentLecturerDto);
		if(lss == null) {
			ResponseEntity response = new ResponseEntity("Failed" ,"Data is empty to add!");
			return response;	
		}
    	ResponseEntity<StudentLecturerEntity> response = new ResponseEntity<>("Success" ,"Data Successfully Added!", lss);
		return response;
    }
    
    //tampilkan semua data di studlec_db
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<StudentLecturerEntity>> readAllSudentLecturer() {
        List<StudentLecturerEntity> lecturerSubjects = studentLecturerService.getAllStudentLecturer();
        if(lecturerSubjects!= null) {
        	ResponseEntity responseEntity = new ResponseEntity("Success" ,"Data Found!", lecturerSubjects);	
            return responseEntity;
        }else {
         	ResponseEntity responseEntity = new ResponseEntity("Failed" ,"Data Not Found!", lecturerSubjects);	
            return responseEntity;
        }	
    }
	
	//membaca id dari id  
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<StudentLecturerEntity>> getDataById(@PathVariable Integer id) {
      // Retrieve data by ID from your data service
		Optional<StudentLecturerEntity> se = studentLecturerService.getDatabyId(id);
//		List<StudentLecturerEntity> se = studentLecturerService.getDatabyLecId(lecturerId);
		if (se != null) {
    		ResponseEntity responseEntity = new ResponseEntity("Success","Data Found!", se);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity("Failed","Data not found",se);		
        	return responseEntity2;
        }
	}
	
	//Read id dari lecturer id
	@RequestMapping(value = "/lecturers/{lecturer_id}/students", method = RequestMethod.GET)
	public ResponseEntity<List<StudentLecturerEntity>> findAllByLecturerId(@PathVariable("lecturer_id") Integer lecturer_id) {
      // Retrieve data by ID from your data service
		List<StudentLecturerEntity> se = studentLecturerService.findAllByLecturerId(lecturer_id);
		if (se != null) {
    		ResponseEntity responseEntity = new ResponseEntity("Success","Data Found!", se);		
        	return responseEntity;
        } else {
    		ResponseEntity responseEntity2 = new ResponseEntity("Failed","Data not found",se);		
        	return responseEntity2;
        }
	}
	
	//Read id dari student id
	@RequestMapping(value = "/students/{student_id}/lecturers", method = RequestMethod.GET)
	public ResponseEntity<List<StudentLecturerEntity>> findAllByStudentId(@PathVariable("student_id") Integer student_id) {
      // Retrieve data by ID from your data service
		List<StudentLecturerEntity> se = studentLecturerService.findAllByStudentId(student_id);
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
		return "Student-Lecutrer data successfully deleted with status " + studentLecturerService.deleteDataById(id);
	}
}
