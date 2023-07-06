package com.example.tutorials.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lecturer_id", nullable = false, unique = true)
    @NotNull
    public LecturerEntity lecturer_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id", nullable = false, unique = true)
    @NotNull
    public SubjectEntity subject_id;
    
	
}
