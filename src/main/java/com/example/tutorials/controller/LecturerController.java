package com.example.tutorials.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutorials.entity.LecturerEntity;
import com.example.tutorials.service.LecturerService;

@RestController
@RequestMapping("/api")
public class LecturerController {
	
	@Autowired
	private LecturerService lecturerService;
	
	@RequestMapping(value = "/addNewLecturer", method = RequestMethod.POST)
	public LecturerEntity addLecturer(@RequestBody LecturerEntity lecturerEntity) {
		return lecturerService.addNewLecturer(lecturerEntity);
	}
	
	@RequestMapping(value = "/viewAllLecturers", method = RequestMethod.GET)
	public List<LecturerEntity> readAllLecturer(){
		return lecturerService.getAllLecturer();
	}
	
	@RequestMapping(value = "/updateLecturer/{id}", method = RequestMethod.PATCH)
	public LecturerEntity updateLecturer(@PathVariable(value = "id") Integer id, @RequestBody LecturerEntity lecturerEntity){	
		return lecturerService.updateLecturer(id, lecturerEntity);
	}
	@RequestMapping(value = "/deleteLecturer/{id}", method = RequestMethod.DELETE)
	public void deleteLecturer(@PathVariable(value = "id") Integer id) {
		lecturerService.deleteLecturer(id);
	}
}
