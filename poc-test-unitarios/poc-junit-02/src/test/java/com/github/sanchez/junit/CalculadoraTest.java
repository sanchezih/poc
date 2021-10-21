package com.github.sanchez.junit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.github.sanchezih.junit.Calculadora;
import com.github.sanchezih.junit.Extractor;

public class CalculadoraTest {

	@Mock
	Extractor extractor;

	@InjectMocks
	Calculadora calculadora = new Calculadora();

	@Test
	public void dimeElResultadoSumaMockTest() {
		MockitoAnnotations.initMocks(this);
		String cadena = "2+3";
		int operandos[] = { 2, 3 };
		when(extractor.extraerOperandos(cadena)).thenReturn(operandos);
		when(extractor.extraerOperador(cadena)).thenReturn("+");
		int resultadoSuma = calculadora.dimeElResultadoDe(cadena);
		assertEquals(5, resultadoSuma);
	}

	@Test
	public void dimeElResultadoSumaTest() {
		int resultadoSuma = calculadora.dimeElResultadoDe("2+3");
		assertEquals(5, resultadoSuma);
	}

	@Test
	public void dimeElResultadoRestaTest() {
		int resultadoSuma = calculadora.dimeElResultadoDe("2-3");
		assertEquals(-1, resultadoSuma);
	}

	@Test(expected = NumberFormatException.class)
	public void dimeElResultadoErrorTest() {
		int resultadoSuma = calculadora.dimeElResultadoDe("P-3");
		assertEquals(17, resultadoSuma);
	}
}