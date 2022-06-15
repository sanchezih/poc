package com.github.sanchezih.wsdl2java;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Runner {

	public static void main(final String[] args) throws MalformedURLException, Exception_Exception {

		final String endpoint = "http://localhost:8080/poc-cxf-java2wsdl/services/PersonasServiceImplPort";

		final URL url = URI.create(endpoint).toURL();

		final PersonasServiceImplService service = new PersonasServiceImplService(url);

		final PersonasSEI soap = service.getPersonasServiceImplPort();

		Persona p = soap.getPersona("juan");

		System.out.println(p.apellido);

	}
}