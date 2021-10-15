package edu.curso.java.spring;

public class ExportadorCSV implements Exportador {

	@Override
	public String exportar(String texto) {
		return "Exportando a CSV el texto: " + texto;
	}

}
