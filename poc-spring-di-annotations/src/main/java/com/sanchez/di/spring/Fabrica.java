package com.sanchez.di.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
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
