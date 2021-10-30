package com.github.sanchezih.pocliquibase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sanchezih.pocliquibase.domain.Estudiante;
import com.github.sanchezih.pocliquibase.domain.repository.REstudiante;

@Service
public class EstudianteService implements IEstudiante {

	@Autowired
	REstudiante rEstudiante;

	@Override
	public Estudiante create(Estudiante estudiante) {
		rEstudiante.save(estudiante);
		return estudiante;
	}

}
