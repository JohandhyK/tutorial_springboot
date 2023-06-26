package com.example.tutorials.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.example.tutorials.entity.SubjectEntity;
import com.example.tutorials.entity.WeatherEntity;
import com.example.tutorials.repository.ThirdPartyRepository;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WeatherService {
	
	@Autowired 
	ThirdPartyRepository thirdPartyRepository;
	
	public WeatherEntity addNewWeather(WeatherEntity weatherEntity) {
        WeatherEntity weatherEntity2 = new WeatherEntity();
        weatherEntity2.setCity(weatherEntity.getCity());
        weatherEntity2.setAqi(weatherEntity.getAqi());
       return thirdPartyRepository.save(weatherEntity2);
	}

} 
