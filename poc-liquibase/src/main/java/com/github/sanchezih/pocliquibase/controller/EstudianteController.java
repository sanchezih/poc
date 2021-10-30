package com.github.sanchezih.pocliquibase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.sanchezih.pocliquibase.domain.Estudiante;
import com.github.sanchezih.pocliquibase.service.EstudianteService;

@RestController
public class EstudianteController {

	@Autowired
	EstudianteService estudianteService;

	@PostMapping(path = "/estudiante")
	public ResponseEntity<Estudiante> create(@RequestBody Estudiante e) {
		return new ResponseEntity<>(estudianteService.create(e), HttpStatus.CREATED);
	}

}
