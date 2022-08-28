package com.github.sanchezih.jersey.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.github.sanchezih.jersey.entity.Usuario;

@Path("/users")
public class UsuarioService {

	private static List<Usuario> listaUsuarios = new ArrayList<Usuario>() {
		private static final long serialVersionUID = 1L;
		{
			add(new Usuario("Rosa", "Marfil"));
			add(new Usuario("Pepito", "Grillo"));
			add(new Usuario("Manuela", "Lago"));
		}
	};

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		return Response.ok(listaUsuarios).build();
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	@GET
	@Path("/{name}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("name") String name) {
		Usuario found = null;
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getName().equalsIgnoreCase(name)) {
				found = listaUsuarios.get(i);
			}
		}
		if (found == null) {
			return Response.status(Status.BAD_REQUEST).entity("User not found").build();
		} else {
			return Response.ok(found).build();
		}
	}

	/**
	 * NOTA: Si no existe el constructor vac�o de User, da un error y el userRequest
	 * viene null.
	 * 
	 * @param userRequest
	 * @return
	 */
	@POST
	@Path("/createUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(Usuario userRequest) {

		this.listaUsuarios.add(userRequest);
		// return Response.status(Status.CREATED).build();
		return Response.ok(listaUsuarios).build();

	}

	/**
	 * NOTA: Si no existe el constructor vac�o de User, da un error y el userRequest
	 * viene null.
	 * 
	 * @param userUpdate
	 * @return
	 */
	@PUT
	@Path("/updateUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(Usuario userUpdate) {
		Usuario found = null;
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getName().equalsIgnoreCase(userUpdate.getName())) {
				found = listaUsuarios.get(i);
			}
		}

		if (found == null) {
			return Response.status(Status.BAD_REQUEST).entity("User not found").build();
		} else {
			found.setUsername(userUpdate.getUsername());
			return Response.ok(found).build();
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	@DELETE
	@Path("/deleteUser/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("name") String name) {
		Usuario found = null;
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (listaUsuarios.get(i).getName().equalsIgnoreCase(name)) {
				found = listaUsuarios.get(i);
				listaUsuarios.remove(found);
			}
		}

		if (found == null) {
			return Response.status(Status.BAD_REQUEST).entity("User not found").build();
		} else {
			return Response.ok(listaUsuarios).build();
		}
	}

}