package com.example.tutorials.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tutorials.entity.StudentCitiesEntity;
import com.example.tutorials.entity.StudentLecturerEntity;
import com.example.tutorials.response.ResponseEntity;

import lombok.val;

@Repository
public interface StudentCitiesRepository extends JpaRepository<StudentCitiesEntity, Integer>{

	@Query(nativeQuery = true,
			value = "SELECT * FROM student_cities_db scdb where "
					+ "scdb.student_id = :student_id")
	List<StudentCitiesEntity> findAllByStudentId(@Param(value = "student_id") Integer student_id);

	@Query(nativeQuery = true,
			value = "SELECT * FROM student_cities_db scdb where "
					+ "scdb.cities_id = :cities_id")
	List<StudentCitiesEntity> findAllByCitiesId(@Param(value = "cities_id") Integer cities_id);


	@Transactional
	@Modifying
	@Query(nativeQuery = true,
			value = "DELETE from student_cities_db scdb where "
					+ "scdb.id = :id")
	Integer deleteDataById(@Param(value = "id")Integer id);

}
