package com.example.tutorials.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tutorials.entity.LecturerSubjectsEntity;
import com.example.tutorials.entity.StudentLecturerEntity;
import com.example.tutorials.response.ResponseEntity;

@Repository
public interface LecturerSubjectRepository extends JpaRepository<LecturerSubjectsEntity, Integer>{

	@Query(nativeQuery = true,
			value = "SELECT * FROM lecturer_subject_db lsdb where "
					+ "lsdb.lecturer_id = :lecturer_id")
	List<LecturerSubjectsEntity> findAllByLecturerId(@Param(value = "lecturer_id") Integer lecturer_id);

	@Query(nativeQuery = true,
			value = "SELECT * FROM lecturer_subject_db lsdb where "
					+ "lsdb.subject_id = :subject_id")
	List<LecturerSubjectsEntity> findAllBySubjectId(@Param(value = "subject_id") Integer subject_id);

	@Transactional
	@Modifying
	@Query(nativeQuery = true,
			value = "DELETE from lecturer_subject_db lsdb where "
					+ "lsdb.id = :id")
	Integer deleteDataById(@Param(value = "id") Integer id);	
}
