package edu.curso.java.spring;

public class ExportadorXML implements Exportador {

	@Override
	public String exportar(String texto) {
		return "Exportando a XML el texto: " + texto;
	}
}
