package edu.curso.java.spring;

public class GeneradorDeDocumento {

	private Exportador exportador;

	public void exportarDatos(String texto) {
		System.out.println(exportador.exportar(texto));
	}

	public Exportador getExportador() {
		return this.exportador;
	}

	public void setExportador(Exportador exportador) {
		this.exportador = exportador;
	}
}
