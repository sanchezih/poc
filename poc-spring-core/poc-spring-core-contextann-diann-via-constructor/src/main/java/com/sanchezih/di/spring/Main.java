package com.sanchezih.di.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext();
		factory.register(SpringConfigurador.class);
		factory.refresh();

		Libro libro = (Libro) factory.getBean("libro");
		System.out.println("- " + libro.getTitulo());
		System.out.println("- " + libro.getAutor().getNombre() + " " + libro.getAutor().getApellido());
		System.out.println("- " + libro.getEditorial());
		System.out.println("- " + libro.getGenero());
		System.out.println("- " + libro.getEdicion());
		System.out.println("- " + libro.getPaginas());
	}
}
