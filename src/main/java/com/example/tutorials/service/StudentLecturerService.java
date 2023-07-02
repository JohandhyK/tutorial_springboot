package com.example.tutorials.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tutorials.dto.StudentLecturerDto;
import com.example.tutorials.entity.LecturerEntity;
import com.example.tutorials.entity.LecturerSubjectsEntity;
import com.example.tutorials.entity.StudentEntity;
import com.example.tutorials.entity.StudentLecturerEntity;
import com.example.tutorials.repository.LecturerRepository;
import com.example.tutorials.repository.StudentLecturerRepository;
import com.example.tutorials.repository.StudentRepository;

@Service
public class StudentLecturerService {
	
	@Autowired
	private StudentLecturerRepository studentLecturerRepository ;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private LecturerRepository lecturerRepository;
	
    public StudentLecturerEntity saveLecturerSubject(StudentLecturerDto studentLecturerDto) {

		Optional<StudentEntity> studentOptional = studentRepository.findById(studentLecturerDto.getStudentId());
		StudentEntity studentEntity = studentOptional.orElseThrow(() ->
		new RuntimeException("Student not found with ID: " + studentLecturerDto.getStudentId())
		);
    	
        Optional<LecturerEntity> lecturerOptional = lecturerRepository.findById(studentLecturerDto.getLecturerId());
        LecturerEntity lecturerEntity = lecturerOptional.orElseThrow(() -> 
        	new RuntimeException("Lecturer not found with ID: " + studentLecturerDto.getLecturerId())
        );
    	StudentLecturerEntity lecturerSubjectsEntity = new StudentLecturerEntity();
    	lecturerSubjectsEntity.setStudent_id(studentEntity);
    	lecturerSubjectsEntity.setLecturer_id(lecturerEntity);
    	
    	return studentLecturerRepository.save(lecturerSubjectsEntity);	
    }
	
    public List<StudentLecturerEntity> getAllStudentLecturer() {
    	return studentLecturerRepository.findAll();
    }
    
    
	public Optional<StudentLecturerEntity> getDatabyId(Integer id) {
        // Retrieve data by ID from your data service
        StudentLecturerEntity se = studentLecturerRepository.findById(id).orElse(null);
//        studentLecturerRepository.findAllById(lecturerId);
        
        return studentLecturerRepository.findById(id);
	}
	
    public List<StudentLecturerEntity> findAllByLecturerId(Integer lecturer_id){
		return studentLecturerRepository.findAllByLecturerId(lecturer_id);
    }
    
    public List<StudentLecturerEntity> findAllByStudentId(Integer student_id){
		return studentLecturerRepository.findAllByStudentId(student_id);
    }
}
