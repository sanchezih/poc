package com.sanchezih.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")
// http://localhost:8080/java-restful/api/hello/ignacio
public class HelloWorldService {

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey dice: " + msg;

		return Response.status(200).entity(output).build();

	}

}