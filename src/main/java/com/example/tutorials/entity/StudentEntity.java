package com.example.tutorials.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity (name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "students")

public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer id;
	
	@Column(name = "first_name")
	@NotBlank
	public String first_name;
	
	@Column(name = "last_name")
	@NotBlank
	public String last_name;
	
	@Column(name = "email")
	@NotBlank
	@Email
	public String email;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "city_id")
//	public CitiesEntity city_id;
	
	@Column(name = "status")
	public Boolean status;
	
	@CreationTimestamp
	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
	public LocalDateTime created_at;
	
	@UpdateTimestamp
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updated_at;
//
//	@OneToOne(mappedBy = "students")
//	private StudentLecturerEntity lecturer;
}
