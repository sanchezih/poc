package com.github.sanchezih.pocliquibase.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.sanchezih.pocliquibase.domain.Estudiante;

@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante, Integer> {

}