package com.example.tutorials.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tutorials.entity.WeatherEntity;

@Repository
public interface ThirdPartyRepository extends JpaRepository<WeatherEntity, Integer>{

}