package com.github.sanchez.junit;

/**
 * Ecuacion de primer grado
 * Solucion:  x = (c - b) / a
 * es decir:  x = (parte3 - parte2)/parte1
 */
public class EcuacionPrimerGrado {

	private Parseador parseador = new Parseador();

	public double obtenerResultado(final String ecuacion) {

		int parte1 = parseador.obtenerParte1(ecuacion);
		int parte2 = parseador.obtenerParte2(ecuacion);
		int parte3 = parseador.obtenerParte3(ecuacion);
		double resultado = Double.valueOf((parte3 - parte2)) / Double.valueOf(parte1);
		return resultado;
	}

}