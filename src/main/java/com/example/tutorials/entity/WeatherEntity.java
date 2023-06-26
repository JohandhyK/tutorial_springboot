package com.example.tutorials.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "weathers")
public class WeatherEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@NotNull
	public Integer id;
	
	@Column(name = "city")
	@NotNull
	public String city;
	
	@Column(name = "aqi")
	@NotNull
	public String aqi;
	
	 public WeatherEntity(String q, String aqi) {
         this.city = city;
         this.aqi = aqi;
     }

}