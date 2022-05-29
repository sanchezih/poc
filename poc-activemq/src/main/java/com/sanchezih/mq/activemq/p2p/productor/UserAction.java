package com.sanchezih.mq.activemq.p2p.productor;

public enum UserAction {

	CONFIGURACION("IR A OPCIONES DE CONFIGURACION"), //
	PORTADA("VER PORTADA"), //
	LOGIN("ACCEDER A LA APLICACION"), //
	SUGERENCIA("ENVIAR SUGERENCIA");

	private final String userAction;

	private UserAction(String userAction) {
		this.userAction = userAction;
	}

	public String getActionAsString() {
		return this.userAction;
	}
}