package com.github.sanchezih.webflux.servidor.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sanchezih.webflux.servidor.model.Factura;

import reactor.core.publisher.Flux;

@RestController
public class FacturasController {

	@GetMapping("/facturas")
	public List<Factura> buscarTodas() {
		List<Factura> lista = new ArrayList<Factura>();
		lista.add(new Factura(1, "computadora", 200));
		lista.add(new Factura(2, "tablet", 300));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return lista;
	}

	@GetMapping("/facturasflux")
	public Flux<Factura> buscarTodasFlux() {
		Flux<Factura> lista = Flux.just(new Factura(1, "computadora", 200), new Factura(2, "tablet", 300))
				.delaySequence(Duration.ofSeconds(3));
		return lista;
	}
}