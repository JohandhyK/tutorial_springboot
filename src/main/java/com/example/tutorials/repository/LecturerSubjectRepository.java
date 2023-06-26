package com.example.tutorials.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tutorials.entity.LecturerSubjectsEntity;

@Repository
public interface LecturerSubjectRepository extends JpaRepository<LecturerSubjectsEntity, Integer>{

}
