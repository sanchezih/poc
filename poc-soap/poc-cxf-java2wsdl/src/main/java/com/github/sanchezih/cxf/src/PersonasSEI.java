package com.github.sanchezih.cxf.src;

import java.util.List;

import javax.jws.WebService;

@WebService(name = "PersonasSEI", targetNamespace = "http://src.cxf.sanchezih.github.com/")
public interface PersonasSEI { // Service Endpoint Interface

	/**
	 * Agrega una persona al listado
	 * 
	 * @param persona
	 */
	public void addPersona(Persona persona);

	/**
	 * Devuelve una persona y en caso de no encontrarla lanza una excepcion
	 * 
	 * @param nombre
	 * @return
	 * @throws Exception
	 */
	public Persona getPersona(String nombre) throws Exception;

	/**
	 * Obtiene el listado de personas almacenado
	 * 
	 * @return
	 */
	public List<Persona> getPersonas();

	/**
	 * Elimina una persona del listado y si no existe lanza una excepcion
	 * 
	 * @param nombre
	 * @throws Exception
	 */
	public void removePersona(String nombre) throws Exception;
}
