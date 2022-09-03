package com.github.sanchezih.jersey.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.sanchezih.jersey.entity.Pais;
import com.github.sanchezih.jersey.service.PaisService;

@Path("/paises")
public class PaisController {

	PaisService paisService = new PaisService();

	/**
	 * http://localhost:8080/poc-jersey-crud-paises/rest/paises
	 * 
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pais> getPaises() {
		List<Pais> paises = paisService.getAllPaises();
		return paises;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pais getPaisById(@PathParam("id") int id) {
		return paisService.getPais(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Pais addCountry(Pais pais) {
		return paisService.addPais(pais);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Pais updateCountry(Pais pais) {
		return paisService.updatePais(pais);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCountry(@PathParam("id") int id) {
		paisService.deletePais(id);
	}

}
