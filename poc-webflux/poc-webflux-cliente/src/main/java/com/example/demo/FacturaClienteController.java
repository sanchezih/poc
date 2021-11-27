package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dominio.Factura;

@Controller
public class FacturaClienteController {

	@Autowired
	ClienteFacturasService servicio;

	@RequestMapping("/lista")
	public String lista(Model modelo) {
		System.out.println("entra...");

		List<Factura> lista = new ArrayList<Factura>();
		lista.addAll(servicio.buscarTodas());
		lista.addAll(servicio.buscarTodas());
		lista.addAll(servicio.buscarTodas());

		modelo.addAttribute("lista", lista);
		return "lista";
	}

	@RequestMapping("/listaflux")
	public String listaFlux(final Model modelo) {

		List<Factura> lista = servicio.buscarTodasFlux().collectList().block();

		modelo.addAttribute("lista", lista);
		return "lista";
	}
}