package com.example.tutorials.dto;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import com.example.tutorials.entity.LecturerEntity;
import com.example.tutorials.entity.LecturerSubjectsEntity;
import com.example.tutorials.entity.SubjectEntity;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LecturerSubjectDto {

	@NotNull
	public Integer lecturerId;
	
	@NotNull
	public Integer subjectId;

}
