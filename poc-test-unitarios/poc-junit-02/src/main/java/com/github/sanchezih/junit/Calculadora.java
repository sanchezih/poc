package com.github.sanchezih.junit;

public class Calculadora {

	private Extractor extractor = new Extractor();

	/**
	 * Comentario de prueba
	 * 
	 * @param cadena
	 * @return
	 */
	public int dimeElResultadoDe(final String cadena) {
		final int[] operandos = extractor.extraerOperandos(cadena);

		final String operador = extractor.extraerOperador(cadena);
		int resultado = 0;

		switch (operador.charAt(0)) {
		case '+':
			resultado = operandos[0] + operandos[1];
			break;
		case '-':
			resultado = operandos[0] - operandos[1];
			break;
		}

		return resultado;
	}

}