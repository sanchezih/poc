package com.sanchezih.di.spring;

import org.springframework.stereotype.Component;

@Component
public class Autor {

	private String nombre = "Luis";
	private String apellido = "Perez";

	public Autor() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}