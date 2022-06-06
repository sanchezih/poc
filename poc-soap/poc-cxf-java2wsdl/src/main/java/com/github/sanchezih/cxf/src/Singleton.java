package com.github.sanchezih.cxf.src;

import java.util.HashMap;
import java.util.Map;

public class Singleton {
	private static final Singleton instance = new Singleton();
	private Map<String, Persona> cuentas = new HashMap<String, Persona>();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return instance;
	}

	public Map<String, Persona> getPersonas() {
		return cuentas;
	}
}
