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
import javax.persistence.OneToMany;
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
@Table(name = "city")

public class CityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@NotNull
	public Integer id;
	
	@Column(name = "name")
	@NotNull
	public String name;
	
	@Column(name = "temp")
	@NotNull
	public Integer temp;
	
	@Column(name = "humidity")
	@NotNull
	public String humidity;
	
	@OneToMany(targetEntity = StudentEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	private List<StudentEntity> studeEntities;
	

}
