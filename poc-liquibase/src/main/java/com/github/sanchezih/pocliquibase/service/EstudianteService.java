package com.github.sanchezih.pocliquibase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sanchezih.pocliquibase.domain.Estudiante;
import com.github.sanchezih.pocliquibase.domain.repository.EstudianteRepository;

@Service
public class EstudianteService implements IEstudiante {

	@Autowired
	EstudianteRepository estudianteRepository;

	@Override
	public Estudiante create(Estudiante estudiante) {
		estudianteRepository.save(estudiante);
		return estudiante;
	}

}
