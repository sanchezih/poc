package com.github.sanchezih.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sanchezih.entity.Product;
import com.github.sanchezih.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> listAll() {
		return productRepository.findAll();
	}

	public void save(Product product) {
		productRepository.save(product);
	}

	public Product get(Long id) {
		return productRepository.findById(id).get();
	}

	public void delete(Long id) {
		productRepository.deleteById(id);
	}
}
