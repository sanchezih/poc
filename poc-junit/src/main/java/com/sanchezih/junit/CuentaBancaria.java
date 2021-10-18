package com.sanchezih.junit;

public class CuentaBancaria {
	private float saldo = 0;
	private String propietario = "";

	public CuentaBancaria(String propietario, float monto) {
		this.propietario = propietario;
		this.saldo = monto;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float f) {
		saldo = f;
	}

	public float extraerSinErrores(float monto) {
		saldo -= monto;
		return saldo;
	}

	public float extraerConErrores(float monto) {
		saldo -= monto + 10;
		return saldo;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String string) {
		propietario = string;
	}

}
