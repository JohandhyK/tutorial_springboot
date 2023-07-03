package com.example.tutorials.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.tutorials.dto.LecturerSubjectDto;
import com.example.tutorials.entity.LecturerEntity;
import com.example.tutorials.entity.LecturerSubjectsEntity;
import com.example.tutorials.entity.StudentCitiesEntity;
import com.example.tutorials.entity.StudentEntity;
import com.example.tutorials.entity.StudentLecturerEntity;
import com.example.tutorials.entity.SubjectEntity;
import com.example.tutorials.repository.LecturerRepository;
import com.example.tutorials.repository.LecturerSubjectRepository;
import com.example.tutorials.repository.SubjectRepository;
import com.example.tutorials.response.ResponseEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LecturerSubjectService {

		@Autowired
	    private LecturerSubjectRepository lecturerSubjectRepository;
		
		@Autowired
		private SubjectRepository subjectRepository;
		
		@Autowired
		private LecturerRepository lecturerRepository;
	
	    public LecturerSubjectsEntity saveLecturerSubject(LecturerSubjectDto lecturerSubjectDTO) {
	
	            Optional<LecturerEntity> lecturerOptional = lecturerRepository.findById(lecturerSubjectDTO.getLecturerId());
	            LecturerEntity lecturerEntity = lecturerOptional.orElseThrow(() -> 
	            	new RuntimeException("Lecturer not found with ID: " + lecturerSubjectDTO.getLecturerId())
	            );
	            Optional<SubjectEntity> subjectOptional = subjectRepository.findById(lecturerSubjectDTO.getSubjectId());
	            SubjectEntity subjectEntity = subjectOptional.orElseThrow(() ->
	            	new RuntimeException("Subject not found with ID: " + lecturerSubjectDTO.getSubjectId())
	            );
	            
	        	LecturerSubjectsEntity lecturerSubjectsEntity = new LecturerSubjectsEntity();
	        	lecturerSubjectsEntity.setLecturer_id(lecturerEntity);
	        	lecturerSubjectsEntity.setSubject_id(subjectEntity);
	        	
	        	return lecturerSubjectRepository.save(lecturerSubjectsEntity);
	    }
	
	    public List<LecturerSubjectsEntity> getAllLecturerSubjects() {
	        return lecturerSubjectRepository.findAll();
	    }
	    
	    public List<LecturerSubjectsEntity> findAllByLecturerId(Integer lecturer_id){
			return lecturerSubjectRepository.findAllByLecturerId(lecturer_id);
	    }
	    
	    public List<LecturerSubjectsEntity> findAllBySubjectId(Integer subject_id){
			return lecturerSubjectRepository.findAllBySubjectId(subject_id);
	    }
	    
		public Optional<LecturerSubjectsEntity> getDatabyId(Integer id) {
	        // Retrieve data by ID from your data service
			LecturerSubjectsEntity se = lecturerSubjectRepository.findById(id).orElse(null);
//	        studentLecturerRepository.findAllById(lecturerId);
	        
	        return lecturerSubjectRepository.findById(id);
		}

		public Integer deleteDataById(Integer id) {
			return lecturerSubjectRepository.deleteDataById(id);
		}

}
