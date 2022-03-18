package com.github.sanchezih.jersey.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.sanchezih.jersey.entity.Pais;

/**
 * Esta es solo una clase auxiliar que debe ser reemplazada por la
 * implementacion de la base de datos.
 * 
 * @author ihsanch
 *
 */
public class PaisService {

	static HashMap<Integer, Pais> paisIdMap = getPaisIdMap();

	public PaisService() {
		super();

		if (paisIdMap == null) {
			paisIdMap = new HashMap<Integer, Pais>();

			// Inicializacion
			Pais argentina = new Pais(1, "Argentina", 45000000);
			Pais uruguay = new Pais(4, "Uruguay", 3000000);
			Pais chile = new Pais(3, "Chile", 19000000);
			Pais brasil = new Pais(2, "Brasil", 212000000);

			paisIdMap.put(1, argentina);
			paisIdMap.put(4, uruguay);
			paisIdMap.put(3, chile);
			paisIdMap.put(2, brasil);
		}
	}

	public List<Pais> getAllPaises() {
		List<Pais> paises = new ArrayList<Pais>(paisIdMap.values());
		return paises;
	}

	public Pais getPais(int id) {
		Pais pais = paisIdMap.get(id);
		return pais;
	}

	public Pais addPais(Pais pais) {
		pais.setId(paisIdMap.size() + 1);
		paisIdMap.put(pais.getId(), pais);
		return pais;
	}

	public Pais updatePais(Pais pais) {
		if (pais.getId() <= 0) {
			return null;
		}
		paisIdMap.put(pais.getId(), pais);
		return pais;
	}

	public void deletePais(int id) {
		paisIdMap.remove(id);
	}

	public static HashMap<Integer, Pais> getPaisIdMap() {
		return paisIdMap;
	}
}
