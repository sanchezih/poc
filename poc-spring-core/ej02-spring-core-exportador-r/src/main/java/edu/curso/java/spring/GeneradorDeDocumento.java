package edu.curso.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.curso.java.spring.service.Exportador;

@Component
public class GeneradorDeDocumento {

	@Autowired
	@Qualifier("exportadorXML")
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
