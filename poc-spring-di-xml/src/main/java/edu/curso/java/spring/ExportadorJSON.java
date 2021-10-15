package edu.curso.java.spring;

public class ExportadorJSON implements Exportador {

	@Override
	public String exportar(String texto) {
		return "Exportando a JSON el texto: " + texto;
	}

}
