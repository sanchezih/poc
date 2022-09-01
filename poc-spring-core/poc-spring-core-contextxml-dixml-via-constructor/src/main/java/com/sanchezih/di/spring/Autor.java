package com.sanchezih.di.spring;

public class Autor {

	private String nombre;
	private String apellido;

	public Autor(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

}