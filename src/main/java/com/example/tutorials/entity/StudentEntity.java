package com.example.tutorials.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
@Table(name = "students")

public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer id;
	
	@Column(name = "first_name")
	@NotNull
	public String first_name;
	
	@Column(name = "last_name")
	@NotNull
	public String last_name;
	
	@Column(name = "email")
	@NotNull
	public String email;
	
//	@Column(name = "city_id")
//	public Integer city_id;
	
	@Column(name = "status_deleted")
	public Boolean status_deleted = false;
	
	@CreationTimestamp
	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
	public LocalDateTime created_at;
	
	@UpdateTimestamp
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updated_at;
	
}
