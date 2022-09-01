package com.sanchezih.di.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sanchezih.di.spring.service.Converter;

public class Main {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		double cantidad = 100;
		Converter c = (Converter) applicationContext.getBean("arsToGbp");
		System.out.println(c.convert(cantidad));

	}
}
