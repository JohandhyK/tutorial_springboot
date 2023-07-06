package com.example.tutorials.service;

import java.util.List;

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
import com.example.tutorials.dto.CitiesDTO;
import com.example.tutorials.dto.StoreDataDTO;
import com.example.tutorials.entity.CitiesEntity;
import com.example.tutorials.repository.ThirdPartyRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WeatherService {
	
	private final RestTemplate restTemplate;
	
	@Autowired 
	ThirdPartyRepository thirdPartyRepository;
	
	   public WeatherService(RestTemplate restTemplate, ThirdPartyRepository weatherDataRepository) {
	        this.restTemplate = restTemplate;
	        this.thirdPartyRepository = weatherDataRepository;
	    }
	
	private static String API_URL = "";
	
    public CitiesEntity getCurrentWeatherData(String API, CitiesDTO cities) {
    	API_URL = API;
        StoreDataDTO response = restTemplate.getForObject(API_URL, StoreDataDTO.class);
		System.out.println("After getting rest template: " + response);

        CitiesEntity weatherData = new CitiesEntity();
        weatherData.setCity(cities.getCity());
        weatherData.setAqi(cities.getAqi());
        weatherData.setCountry(response.getLocation().getCountry());
        weatherData.setRegion(response.getLocation().getRegion());
        weatherData.setTemp_c(response.getCurrent().getTemp_c());
        weatherData.setDate_time(response.getLocation().getLocaltime());
        return weatherData;
    }
	

    public void saveWeatherData(CitiesEntity weatherData) {
    	thirdPartyRepository.save(weatherData);
    }
} 
