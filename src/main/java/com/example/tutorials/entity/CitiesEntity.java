package com.example.tutorials.entity;

import java.sql.Timestamp;
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
@Table(name = "cities")
public class CitiesEntity {

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
	
	@Column(name = "country")
	public String country;
	
	@Column(name = "region")
	public String region;
	
	@Column(name = "temp_c")
	public Double temp_c;

	@Column(name = "date_time")
	public String date_time;

}
