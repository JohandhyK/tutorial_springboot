package com.example.tutorials.entity;

import javax.persistence.CascadeType;
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

@Entity (name = "student_cities_db")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "student_cities_db")
public class StudentCitiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@NotNull
	public Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    public StudentEntity student_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cities_id")
    public CitiesEntity cities_id;
}
