package com.example.tutorials.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tutorials.entity.LecturerEntity;
import com.example.tutorials.response.ResponseEntity;

@Repository
public interface LecturerRepository extends JpaRepository<LecturerEntity, Integer>{

	@Transactional
	@Modifying
	@Query(nativeQuery = true,
			value = "DELETE from lecturers l where "
					+ "l.id = :id")
	Integer deleteDataById(@Param(value = "id") Integer id);
	
//    boolean checkifExistsById(Integer id);
	
	@Query(nativeQuery = true,
			value = "SELECT COUNT(:lecturer_id) from lecturers l where "
					+ "l.id = :lecturer_id")
	Optional<LecturerEntity> countId(@Param(value = "lecturer_id") Integer lecturer_id);

}
