package com.sanchez.di.spring;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
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
		System.out.println("Hola a todos!!!! mi nombre es " + nombre);
	}
	@Override
	public void hablar(String texto) {
		System.out.println("hola a todos " + texto);
	}
}
