package com.github.sanchezih.junit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import com.github.sanchezih.junit.EcuacionPrimerGrado;

/**
 * A continuación, se muestra un ejemplo de un test de integración donde se
 * verifica la interacción del componente EcuacionPrimerGrado y el Parseador.
 * Los test comprueban que el resultado final de la ecuación es correcto.
 * 
 * @author ihsanch
 *
 */
public class EcuacionPrimerGradoIntegrationTest {

	EcuacionPrimerGrado ecuacion = new EcuacionPrimerGrado();

	@Test
	public void solucionaEcuacionConMenos() {

		Double result = ecuacion.obtenerResultado("2x - 1 = 0");

		Double valueExpected = 0.5;

		assertEquals(valueExpected, result);
	}

	@Test
	public void solucionaEcuacionConMas() {

		Double result = ecuacion.obtenerResultado("2x + 1 = 0");

		Double valueExpected = -0.5;

		assertEquals(valueExpected, result);
	}

	@Test
	public void solucionaEcuacionConParte3Mayor0() {

		Double result = ecuacion.obtenerResultado("2x + 1 = 10");

		Double valueExpected = 4.5;

		assertEquals(valueExpected, result);
	}

}
