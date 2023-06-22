package com.example.tutorials.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tutorials.entity.LecturerEntity;

@Repository
public interface LecturerRepository extends JpaRepository<LecturerEntity, Integer>{

}
