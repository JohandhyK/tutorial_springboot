package com.example.tutorials.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tutorials.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
	
	@Query(nativeQuery = true,
			value = "SELECT * FROM students s where "
					+ "s.first_name=:first_name")
	List<StudentEntity>findByfirstnameIs(@Param ("first_name") String first_name);
	
	@Query(nativeQuery = true,
			value = "SELECT * FROM students s where "
					+ "s.status = 1")
	List<StudentEntity>getAllByStatus();
}
