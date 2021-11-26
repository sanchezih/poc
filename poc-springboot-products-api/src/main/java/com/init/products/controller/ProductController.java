package com.init.products.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.products.dao.ProductsDAO;
import com.init.products.entity.Product;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	private ProductsDAO productDAO;

	@GetMapping
	public ResponseEntity<List<Product>> getProduct() {
		List<Product> products = productDAO.findAll();
		return ResponseEntity.ok(products);
	}

	@RequestMapping(value = "{productId}") // /products/{productId}
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId) {

		Optional<Product> optionalProduct = productDAO.findById(productId);
		if (optionalProduct.isPresent()) {
			return ResponseEntity.ok(optionalProduct.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product newProduct = productDAO.save(product);
		return ResponseEntity.ok(newProduct);
	}

	@DeleteMapping(value = "{productId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("productId") Long productId) {
		productDAO.deleteById(productId);
		return ResponseEntity.ok(null);
	}

	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Optional<Product> optionalProduct = productDAO.findById(product.getId());
		if (optionalProduct.isPresent()) {
			Product updatedProduct = optionalProduct.get();
			updatedProduct.setName(product.getName());
			productDAO.save(updatedProduct);
			return ResponseEntity.ok(updatedProduct);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
