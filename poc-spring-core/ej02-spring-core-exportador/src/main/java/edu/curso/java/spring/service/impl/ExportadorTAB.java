package edu.curso.java.spring.service.impl;

import edu.curso.java.spring.Persona;
import edu.curso.java.spring.service.Exportador;

public class ExportadorTAB implements Exportador {

	@Override
	public String exportar(Persona persona) {
		return persona.getNombre() + "\t" + persona.getEdad() + "\t" + persona.getDireccion();
	}

}
