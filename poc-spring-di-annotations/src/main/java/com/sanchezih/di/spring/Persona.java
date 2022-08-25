package com.sanchezih.di.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // Estereotipo generico para cualquier componente administrado por Spring
@Scope("prototype")
public class Persona implements SerVivo {

	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void saludar() {
		System.out.println("Hola, mi nombre es " + nombre);
	}

	@Override
	public void hablar(String texto) {
		System.out.println("Digo: " + texto);
	}
}
