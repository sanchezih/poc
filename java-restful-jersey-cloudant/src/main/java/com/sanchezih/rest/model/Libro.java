package com.sanchezih.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Libros")
public class Libro {

	private String _id;
	private String _rev;
	private String titulo;
	private String description;
	private String year;
	private String by;

	public String get_rev() {
		return _rev;
	}

	public void set_rev(String _rev) {
		this._rev = _rev;
	}

	private long likes;

	public void setTitle(String titulo) {
		this.titulo = titulo;
		set_id();
	}

	public void setDescription(String String) {
		this.description = String;
	}

	public void setLikes(long String) {
		this.likes = String;
	}

	public void setYear(String String) {
		this.year = String;
	}

	public void setBy(String String) {
		this.by = String;
	}

	public void set_id() {
		this._id = titulo;
	}

	@XmlElement
	public String getTitulo() {
		return this.titulo;
	}

	@XmlElement
	public String getDescription() {
		return this.description;
	}

	@XmlElement
	public long getLikes() {
		return this.likes;
	}

	@XmlElement
	public String getYear() {
		return this.year;
	}

	@XmlElement
	public String getBy() {
		return this.by;
	}
}