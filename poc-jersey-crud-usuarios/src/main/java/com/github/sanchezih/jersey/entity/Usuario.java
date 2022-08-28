package com.github.sanchezih.jersey.entity;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	public String name;
	public String username;

	public Usuario() {
		super();
	}

	public Usuario(String name, String username) {
		super();
		this.name = name;
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}