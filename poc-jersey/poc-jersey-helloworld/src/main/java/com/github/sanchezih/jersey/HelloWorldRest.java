package com.github.sanchezih.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("helloworld")
public class HelloWorldRest {


	public HelloWorldRest() {
	}

	/**
	 * Ingresar desde un browser a la siguiente url:
	 * http://localhost:8080/poc-jersey-helloworld/rest/helloworld
	 * 
	 * @return
	 */
	@GET
	@Produces("text/html")
	public String getHtml() {
		return "<html lang=\"en\"><body><h1>Hola Mundo!</h1></body></html>";
	}
}