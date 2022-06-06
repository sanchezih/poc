package com.github.sanchezih.cxf.src;

import java.util.ArrayList;
import java.util.List;

public class PersonasServiceImpl implements PersonasSEI {

	@Override
	public void addPersona(Persona persona) {
		Singleton.getInstance().getPersonas().put(persona.getNombre(), persona);
	}

	@Override
	public Persona getPersona(String nombre) throws Exception {
		Persona persona = Singleton.getInstance().getPersonas().get(nombre);
		if (persona == null) {
			throw new Exception("La persona buscada no existe");
		}
		return persona;
	}

	@Override
	public List<Persona> getPersonas() {
		return new ArrayList<Persona>(Singleton.getInstance().getPersonas().values());
	}

	@Override
	public void removePersona(String nombre) throws Exception {
		Persona persona = Singleton.getInstance().getPersonas().get(nombre);
		if (persona == null) {
			throw new Exception("La persona buscada no existe");
		} else {
			Singleton.getInstance().getPersonas().remove(nombre);
		}
	}

}
