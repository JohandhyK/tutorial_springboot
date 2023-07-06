package com.example.tutorials.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.validation.Valid;

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
import com.example.tutorials.repository.StudentRepository;
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

	    	if(lecturerSubjectDTO.getLecturerId() == null && lecturerSubjectDTO.getSubjectId() == null) {
	    		new RuntimeException("Either data is null with Lecturer ID : " + lecturerSubjectDTO.getLecturerId()
	    			+ " or with Subjects ID : " + lecturerSubjectDTO.getSubjectId());
	    		return null;
	    	}
	    	
            Optional<LecturerEntity> lecturerOptional = lecturerRepository.findById(lecturerSubjectDTO.getLecturerId());
	        LecturerEntity lecturerEntity = lecturerOptional.orElseThrow(() -> 
        		new RuntimeException("Lecturer not found with ID: " + lecturerSubjectDTO.getLecturerId()));
            
	        Optional<SubjectEntity> subjectOptional = subjectRepository.findById(lecturerSubjectDTO.getSubjectId());
            SubjectEntity subjectEntity = subjectOptional.orElseThrow(() ->
            	new RuntimeException("Subject not found with ID: " + lecturerSubjectDTO.getSubjectId()));
	    	
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
	        return lecturerSubjectRepository.findById(id);
		}

		public Integer deleteDataById(Integer id) {
			return lecturerSubjectRepository.deleteDataById(id);
		}

		public LecturerSubjectsEntity updateLecturerData(Integer id, 
				LecturerSubjectDto lecturerSubjectDto) {
			
			if(lecturerSubjectDto.getLecturerId() == null && lecturerSubjectDto.getSubjectId() == null) {
	    		new RuntimeException("Either data is null with Lecturer ID : " + lecturerSubjectDto.getLecturerId()
	    			+ " or with Subjects ID : " + lecturerSubjectDto.getSubjectId());
	    		return null;
	    	}
	    	
            Optional<LecturerEntity> lecturerOptional = lecturerRepository.findById(lecturerSubjectDto.getLecturerId());
	        LecturerEntity lecturerEntity = lecturerOptional.orElseThrow(() -> 
        		new RuntimeException("Lecturer not found with ID: " + lecturerSubjectDto.getLecturerId()));
            
	        Optional<SubjectEntity> subjectOptional = subjectRepository.findById(lecturerSubjectDto.getSubjectId());
            SubjectEntity subjectEntity = subjectOptional.orElseThrow(() ->
            	new RuntimeException("Subject not found with ID: " + lecturerSubjectDto.getSubjectId()));
	    	
			LecturerSubjectsEntity le = lecturerSubjectRepository.findById(id).get();
        	le.setLecturer_id(lecturerEntity);
        	le.setSubject_id(subjectEntity);
			
        	return lecturerSubjectRepository.save(le);
		}


}
