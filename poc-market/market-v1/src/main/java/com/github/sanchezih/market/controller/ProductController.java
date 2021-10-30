package com.github.sanchezih.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sanchezih.market.domain.Product;
import com.github.sanchezih.market.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping(path = "/product")
	public Product getProduct() {
		return productService.get();
	}

	@GetMapping(path = "/holamundo")
	public String getHolaMundo() {
		return "Hola mundo!";
	}
}
