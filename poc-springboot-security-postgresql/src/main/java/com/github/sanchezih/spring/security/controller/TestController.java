package com.github.sanchezih.spring.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

	@GetMapping("/all")
	public String allAccess() {
		return "Mostrando contenido publico...";
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return "Mostrando contenido para 'USER' o 'ADMIN'...";
	}

//	@GetMapping("/mod")
//	@PreAuthorize("hasRole('MODERATOR')")
//	public String moderatorAccess() {
//		return "Mostrando contenido para 'MODERATOR'...";
//	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Mostrando contenido para 'ADMIN'...";
	}
}
