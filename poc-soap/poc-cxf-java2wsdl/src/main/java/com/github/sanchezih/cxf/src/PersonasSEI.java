package com.github.sanchezih.cxf.src;



import java.util.List;



public interface PersonasSEI {
	/**
	 * Añade una persona al listado
	 * 
	 * @param persona
	 */
	void addPersona(Persona persona);

	/**
	 * Devuelve una persona y en caso de no encontrarla lanza una excepcion
	 * 
	 * @param nombre
	 * @return
	 * @throws Exception
	 */
	Persona getPersona(String nombre) throws Exception;

	/**
	 * Obtiene el listado de personas almacenado
	 * 
	 * @return
	 */
	List<Persona> getPersonas();

	/**
	 * Elimina una persona del listado y si no existe lanza una excepcion
	 * 
	 * @param nombre
	 * @throws Exception
	 */
	void removePersona(String nombre) throws Exception;
}
