package com.github.sanchezih;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Ejercicio basado en
 * https://www.codejava.net/frameworks/spring-boot/form-authentication-with-jdbc-and-mysql
 * 
 * @author ihsanch
 *
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
