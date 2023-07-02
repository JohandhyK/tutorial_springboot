package com.example.tutorials.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tutorials.dto.StudentCitiesDTO;
import com.example.tutorials.dto.StudentLecturerDto;
import com.example.tutorials.entity.CitiesEntity;
import com.example.tutorials.entity.LecturerEntity;
import com.example.tutorials.entity.StudentCitiesEntity;
import com.example.tutorials.entity.StudentEntity;
import com.example.tutorials.entity.StudentLecturerEntity;
import com.example.tutorials.repository.LecturerRepository;
import com.example.tutorials.repository.StudentCitiesRepository;
import com.example.tutorials.repository.StudentRepository;
import com.example.tutorials.repository.ThirdPartyRepository;

@Service
public class StudentCitiesService {

	@Autowired
	private StudentCitiesRepository studentCitiesRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ThirdPartyRepository thirdPartyRepository;
	
    public StudentCitiesEntity saveStudentCities(StudentCitiesDTO studentCitiesDTO) {

		Optional<StudentEntity> studentOptional = studentRepository.findById(studentCitiesDTO.getStudentId());
		StudentEntity studentEntity = studentOptional.orElseThrow(() ->
		new RuntimeException("Student not found with ID: " + studentCitiesDTO.getStudentId())
		);
    	
        Optional<CitiesEntity> citiesOptional = thirdPartyRepository.findById(studentCitiesDTO.getCitiesId());
        CitiesEntity citiesEntity = citiesOptional.orElseThrow(() -> 
        	new RuntimeException("Cities not found with ID: " + studentCitiesDTO.getCitiesId())
        );
    	StudentCitiesEntity studentCitiesEntity = new StudentCitiesEntity();
    	studentCitiesEntity.setStudent_id(studentEntity);
    	studentCitiesEntity.setCities_id(citiesEntity);
    	
    	return studentCitiesRepository.save(studentCitiesEntity);
    }
	
    public List<StudentCitiesEntity> getAllLecturerSubjects() {
    	return (List<StudentCitiesEntity>) studentCitiesRepository.findAll();
    }
    
    
	public Optional<StudentCitiesEntity> getDatabyId(Integer id) {
        // Retrieve data by ID from your data service
		StudentCitiesEntity se = studentCitiesRepository.findById(id).orElse(null);
//        studentLecturerRepository.findAllById(lecturerId);
        
        return studentCitiesRepository.findById(id);
	}
	
    public List<StudentCitiesEntity> findAllByStudentId(Integer student_id){
		return studentCitiesRepository.findAllByStudentId(student_id);
    }
    
    public List<StudentCitiesEntity> findAllByCitiesId(Integer id){
		return studentCitiesRepository.findAllByCitiesId(id);
    }
}
