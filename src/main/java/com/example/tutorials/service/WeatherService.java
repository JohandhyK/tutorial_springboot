package com.example.tutorials.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WeatherService {
	
	private static final String API_KEY = "62237a756fac460888484403232206";
	private static final String API_URL = "http://api.weatherapi.com/v1/current.json";
	private static final String city = "";
	private static final String q = "no";

	@Autowired
	private RestTemplate restTemplate;
	 
	public Object getWeather() {
		 try {
			 HttpHeaders header = new HttpHeaders();
//			 header.set("API_URL", API_URL);
			 header.set("API_KEY", API_KEY);
			 ResponseEntity<String> response = restTemplate.exchange(API_KEY, HttpMethod.GET, new HttpEntity<>(header), String.class);

			 return response.getBody();
		} catch (Exception e) {
			log.error("Invalid data", e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception on finding the weather data!",e);
	
		}
	}
} 
