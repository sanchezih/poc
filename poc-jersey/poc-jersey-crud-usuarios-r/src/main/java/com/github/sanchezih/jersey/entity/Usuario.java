package com.github.sanchezih.jersey.entity;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	public String username;
	public String name;

	public Usuario() {
	}

	public Usuario(String username, String name) {
		super();
		this.username = username;
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}