package com.example.tutorials.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity (name = "lecturer_subject_db")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "lecturer_subject_db")
public class LecturerSubjectsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@NotNull
	public Integer id;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    public LecturerEntity lecturer_id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    public SubjectEntity subject_id;
    
	
}
