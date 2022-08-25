package com.sanchezih.di.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		Fabrica fabrica = applicationContext.getBean(Fabrica.class);

		fabrica.getSerVivo().hablar("chau!!!");

	}
}
