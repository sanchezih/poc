package com.github.sanchezih.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sanchezih.entity.Product;
import com.github.sanchezih.repository.ProductRepository;

@Service
public class ProductRestServiceImpl {

	@Autowired
	ProductRepository productRepository;

	public List<Product> getAll() {
		return productRepository.findAll();
	}

}
