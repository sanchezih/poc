package com.sanchezih.junit;

import junit.framework.TestCase;

public class CuentaBancariaTest extends TestCase {
	
	private CuentaBancaria cuentaBancaria = null;

	public CuentaBancariaTest(String name) {
		super(name);
	}

	/**
	 * Sets up de la CuentaBancaria
	 */
	public void setUp() {
		cuentaBancaria = new CuentaBancaria("Juan", 500);
	}

	public void testExtraerSinError() {
		float saldo = 0;
		saldo = cuentaBancaria.extraerSinErrores(200);
		assertEquals("extraerSinErrores 200 pesos", 300, cuentaBancaria.getSaldo(), 0.0);
	}

	public void testExtraerConError() {
		float saldo = 0;
		saldo = cuentaBancaria.extraerConErrores(100);
		assertEquals("extraerConErrores 100 pesos", 400, cuentaBancaria.getSaldo(), 0.0);
	}

	public void testExtraerSinErrorGeneral() {
		float saldo = 0;
		saldo = cuentaBancaria.extraerSinErrores(200);
		assertTrue("saldo > 200 pesos", cuentaBancaria.getSaldo() > 200);
		assertNotNull("la cuenta bancaria no es == null", cuentaBancaria);
		assertEquals("El prooietario es el mismo", "Juan", cuentaBancaria.getPropietario());
	}

}
