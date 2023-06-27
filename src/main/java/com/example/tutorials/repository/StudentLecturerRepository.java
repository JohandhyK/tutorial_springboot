package com.example.tutorials.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tutorials.entity.StudentEntity;
import com.example.tutorials.entity.StudentLecturerEntity;

@Repository
public interface StudentLecturerRepository extends JpaRepository<StudentLecturerEntity, Integer>{
    
	@Query(nativeQuery = true,
			value = "SELECT * FROM student_lecturer_db sldb where "
					+ "sldb.lecturer_id = :lecturer_id")
	List<StudentLecturerEntity> findAllByLecturerId(@Param(value = "lecturer_id") Integer lecturer_id);

	@Query(nativeQuery = true,
			value = "SELECT * FROM student_lecturer_db sldb where "
					+ "sldb.student_id = :student_id")
	List<StudentLecturerEntity> findAllByStudentId(@Param(value = "student_id") Integer student_id);


}
