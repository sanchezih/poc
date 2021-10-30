package com.github.sanchezih.pocliquibase.domain.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.sanchezih.pocliquibase.domain.Estudiante;

@Repository
public interface REstudiante extends CrudRepository<Estudiante, Integer> {

//	@Query("SELECT name FROM Estudiante s WHERE s.nombre LIKE %:studentName%")
//	String findByName(String studentName);
}