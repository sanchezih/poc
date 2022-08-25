package com.sanchezih.di.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // Estereotipo generico para cualquier componente administrado por Spring
public class Fabrica {

	@Autowired
	private SerVivo serVivo;

	public SerVivo getSerVivo() {
		return serVivo;
	}

	public void setSerVivo(SerVivo serVivo) {
		this.serVivo = serVivo;
	}

}
