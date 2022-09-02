package com.github.sanchezih.jersey.entity;

import java.io.Serializable;

public class Pais implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private long poblacion;

	public Pais() {
		super();
	}

	public Pais(int i, String nombre, long poblacion) {
		super();
		this.id = i;
		this.nombre = nombre;
		this.poblacion = poblacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(long poblacion) {
		this.poblacion = poblacion;
	}

}