package com.example.tutorials.controller;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.tutorials.entity.SubjectEntity;
import com.example.tutorials.entity.CitiesEntity;
import com.example.tutorials.repository.ThirdPartyRepository;
import com.example.tutorials.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class ThirdPartyController {
	
	 private static final String API_KEY = "62237a756fac460888484403232206";
	 private static final String API_URL = "http://api.weatherapi.com/v1/current.json";

	@Autowired
	private ThirdPartyRepository thirdPartyRepository;
	
	@Autowired
	private WeatherService service;
			
    private final RestTemplate restTemplate;
//
//    public ThirdPartyController(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//    
    public ThirdPartyController(RestTemplate restTemplate, ThirdPartyRepository thirdPartyRepository) {
        this.restTemplate = restTemplate;
        this.thirdPartyRepository = thirdPartyRepository;
    }
    
 	@RequestMapping(value = "/current", method = RequestMethod.GET)
    public ResponseEntity<String> getCurrentWeather(@RequestParam("city") String city,
            @RequestParam(value = "aqi", defaultValue = "no") String aqi) {
 		CitiesEntity weatherEntity = new CitiesEntity();
        String url = API_URL + "?key=" + API_KEY + "&q=" + weatherEntity.getCity()+ "&aqi=" + weatherEntity.getAqi();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
   }
 	
 	//blm di req body
    @GetMapping("/currentWithoutBody")
    public ResponseEntity<String> getCurrentWeather() {
        String city = "London";
        String url = API_URL + "?key=" + API_KEY + "&q=" + city + "&aqi=no";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return ResponseEntity.ok(response.getBody());
    }
    
    @GetMapping("/currentByJson")
    @ResponseBody
    public ResponseEntity<String> getCurrentWeather(@RequestBody CitiesEntity weatherEntity,
                                                    @RequestHeader("API-KEY") String apiKey) {
        String url = API_URL + "?key=" + apiKey + "&q=" + weatherEntity.getCity() + "&aqi=" + weatherEntity.getAqi();

        HttpHeaders headers = new HttpHeaders();          
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        CitiesEntity weatherEntity2 = service.addNewWeather(weatherEntity);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);   
        return ResponseEntity.ok(response.getBody());
    }
}
