package com.example.tutorials.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tutorials.entity.CitiesEntity;

@Repository
public interface ThirdPartyRepository extends JpaRepository<CitiesEntity, Integer>{

}
