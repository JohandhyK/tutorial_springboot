package com.example.tutorials.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "subjects")
public class SubjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@NotNull
	public Integer id;
	
	@Column(name = "name")
	public String first_name;
	
	@CreatedDate
	@Column(name = "createdAt", nullable = false, updatable = false)
	public LocalDateTime createdAt;
	
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
