package edu.curso.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		Persona persona = new Persona("Victoria", 37, "Lugones 4402");

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		GeneradorDeDocumento generadorDeDocumento = (GeneradorDeDocumento) applicationContext
				.getBean("generadorDeDocumento");
		generadorDeDocumento.exportarDatos(persona);

	}
}
