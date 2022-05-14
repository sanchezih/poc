package com.github.sanchezih.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sanchezih.market.dto.ProductDto;
import com.github.sanchezih.market.entity.Product;
import com.github.sanchezih.market.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping()
	public ResponseEntity<List<Product>> getAllCategorias() {
		List<Product> products = productService.getAll();
		return ResponseEntity.ok(products);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Product> get(@PathVariable Long id) {
		return new ResponseEntity<>(productService.get(id), HttpStatus.ACCEPTED);
	}

	@PostMapping()
	public ResponseEntity<Product> create(@RequestBody ProductDto dto) {
		return new ResponseEntity<>(productService.create(dto), HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<Product> update(@RequestBody ProductDto dto) {
		return new ResponseEntity<>(productService.update(dto), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		productService.delete(id);
		return new ResponseEntity<>("Product deleted", HttpStatus.OK);
	}

}
