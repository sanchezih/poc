package edu.curso.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		try {
			GeneradorDeDocumento generadorDeDocumento = (GeneradorDeDocumento) context.getBean("generadorDeDocumento");
			generadorDeDocumento.exportarDatos("Hola a todos...");
		} finally {
			((AbstractApplicationContext) context).close();
		}

	}
}
