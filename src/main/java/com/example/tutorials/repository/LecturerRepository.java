package com.example.tutorials.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tutorials.entity.LecturerEntity;

public interface LecturerRepository extends JpaRepository<LecturerEntity, Integer>{

}
