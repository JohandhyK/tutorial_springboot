package com.example.tutorials.dto;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentCitiesDTO {
	
	@NotNull
	public Integer studentId;
	
	@NotNull
	public Integer citiesId;

}
