package com.lineadecodigo.javaee.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("helloworld")
public class HelloWorldRest {

	@Context
	private UriInfo context;

	public HelloWorldRest() {
	}

	// http://localhost:8080/poc-jersey-helloworld/rest/helloworld
	@GET
	@Produces("text/html")
	public String getHtml() {
		return "<html lang=\"en\"><body><h1>Hola Mundo!!</h1></body></html>";
	}
}