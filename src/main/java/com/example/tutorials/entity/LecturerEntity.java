package com.example.tutorials.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "lecturers")

public class LecturerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@NotNull
	public Integer id;
	
	@Column(name = "name")
	@NotNull
	public String name;
	
	@Column(name = "title")	
	@NotNull
	public String title;
	
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
	
//	@OneToMany(targetEntity = StudentLecturerEntity.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "lecturer_id", referencedColumnName = "id")
//	private List<StudentLecturerEntity> student;
//
//	@OneToMany(targetEntity = LecturerSubjectsEntity.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "lecturer_id", referencedColumnName = "id")
//	private List<LecturerSubjectsEntity> subject;

}
