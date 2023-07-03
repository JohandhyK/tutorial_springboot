package com.example.tutorials.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tutorials.dto.CitiesDTO;
import com.example.tutorials.entity.CitiesEntity;
import com.example.tutorials.response.ResponseEntity;

@Repository
public interface ThirdPartyRepository extends JpaRepository<CitiesEntity, Integer>{
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true,
			value = "DELETE from cities l where "
					+ "c.id = :id")
	ResponseEntity<Integer> deleteDataById(@Param(value = "id") Integer id);
}
