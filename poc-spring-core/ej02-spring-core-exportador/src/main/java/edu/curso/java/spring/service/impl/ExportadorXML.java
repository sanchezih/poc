package edu.curso.java.spring.service.impl;

import edu.curso.java.spring.Persona;
import edu.curso.java.spring.service.Exportador;

public class ExportadorXML implements Exportador {

	@Override
	public String exportar(Persona persona) {
		return generarSalidaXML(persona);

	}

	private String generarSalidaXML(Persona persona) {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		sb.append("<Persona>\n");
		sb.append("   <nombre>" + persona.getNombre() + "</nombre>\n");
		sb.append("   <edad>" + persona.getEdad() + "</edad>\n");
		sb.append("   <direccion>" + persona.getDireccion() + "</direccion>\n");
		sb.append("</Persona>");
		return sb.toString();
	}

}
