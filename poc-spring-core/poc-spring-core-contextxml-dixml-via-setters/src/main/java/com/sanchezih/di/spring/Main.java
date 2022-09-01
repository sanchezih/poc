package com.sanchezih.di.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		BeanFactory applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Libro libro = (Libro) applicationContext.getBean("libro");
		
		System.out.println("- " + libro.getTitulo());
		System.out.println("- " + libro.getAutor().getNombre() + " " + libro.getAutor().getApellido());
		System.out.println("- " + libro.getEditorial());
		System.out.println("- " + libro.getGenero());
		System.out.println("- " + libro.getEdicion());
		System.out.println("- " + libro.getPaginas());
	}
}
