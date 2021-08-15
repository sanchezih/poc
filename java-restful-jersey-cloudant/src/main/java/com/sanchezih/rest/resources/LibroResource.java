
package com.sanchezih.rest.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import com.sanchezih.rest.database.CloudantDBSingleton;
import com.sanchezih.rest.model.Libro;
import com.sanchezih.rest.services.LibroService;

@Path("/libros")
public class LibroResource {

	private LibroService libroService = new LibroService();

	@GET
	@Path("/echo/{mensaje}")
	@Produces("text/plain")
	public String showMsg(@PathParam("mensaje") String msg) {
		return msg;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> getLibros() {
		return libroService.getAllLibros();
	}

	@POST
	@Path("/{name}/{by}/{likes}/{year}/{description}")
	@Produces("text/plain")
	public String insert(@PathParam("name") String name, @PathParam("description") String description,
			@PathParam("likes") Long likes, @PathParam("year") String year, @PathParam("by") String autor) {
		CloudantDBSingleton dbSingleton = CloudantDBSingleton.getInstance();
		Database db = dbSingleton.testDatabase();
		Libro book = new Libro();
		book.setTitle(name);
		book.setDescription(description);
		book.setLikes(likes);
		book.setYear(year);
		book.setBy(autor);
		Response r = db.post(book);
		return "El libro " + r.getId() + " fue creado en " + db.getDBUri();

	}

	@GET
	@Path("/{titulo}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> getLibroByTitulo(@PathParam("titulo") String titulo) {
		CloudantDBSingleton dbSingleton = CloudantDBSingleton.getInstance();
		Database db = dbSingleton.testDatabase();
		List<Libro> libros = db.findByIndex("\"selector\": {\"titulo\": \"" + titulo + "\" }", Libro.class);
		return libros;
	}

	@PUT
	@Path("/{titulo}/{likes}")
	@Produces("text/plain")
	public String updateLibro(@PathParam("titulo") String titulo, @PathParam("likes") long likes) {
		CloudantDBSingleton dbSingleton = CloudantDBSingleton.getInstance();
		Database db = dbSingleton.testDatabase();

		try {
			Libro libro = db.find(Libro.class, titulo);
			libro.setLikes(libro.getLikes() + likes);

			Response r = db.update(libro);
			return "Los likes de " + r.getId() + " se incrementaron a " + libro.getLikes();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@DELETE
	@Path("/{titulo}")
	@Produces("text/plain")
	public String deleteLibro(@PathParam("titulo") String titulo) {
		CloudantDBSingleton dbSingleton = CloudantDBSingleton.getInstance();
		Database db = dbSingleton.testDatabase();
		try {
			Libro libro = db.find(Libro.class, titulo);
			db.remove(libro);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "El libro " + titulo + " ha sido borrado";
	}

}