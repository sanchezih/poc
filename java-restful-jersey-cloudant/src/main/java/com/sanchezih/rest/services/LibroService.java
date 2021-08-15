package com.sanchezih.rest.services;

import java.util.List;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import com.sanchezih.rest.database.CloudantDBSingleton;
import com.sanchezih.rest.model.Libro;

public class LibroService {

	public List<Libro> getAllLibros() {
		CloudantDBSingleton dbSingleton = CloudantDBSingleton.getInstance();
		Database db = dbSingleton.testDatabase();
		List<Libro> list = null;
		try {
			list = db.findByIndex("\"selector\": { \"_id\": { \"$gt\": 0} }", Libro.class);
		} catch (Exception e) {
		}
		return list;
	}
}
