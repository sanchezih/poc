package edu.curso.java.spring;

import edu.curso.java.spring.service.Exportador;

public class GeneradorDeDocumento {

	private Exportador exportador;

	public void exportarDatos(Persona persona) {
		System.out.println(exportador.exportar(persona));
	}

	public Exportador getExportador() {
		return this.exportador;
	}

	public void setExportador(Exportador exportador) {
		this.exportador = exportador;
	}
}
