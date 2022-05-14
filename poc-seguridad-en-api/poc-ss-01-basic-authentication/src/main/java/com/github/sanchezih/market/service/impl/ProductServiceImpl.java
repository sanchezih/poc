package com.github.sanchezih.market.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sanchezih.market.dto.ProductDto;
import com.github.sanchezih.market.entity.Product;
import com.github.sanchezih.market.repository.ProductRepository;
import com.github.sanchezih.market.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}
	
	@Override
	public Product get(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			return product.get();
		}
		return null;
	}

	@Override
	public Product create(ProductDto dto) {
		Product product = new Product();
		product.setName(dto.getName());
		product.setCost(dto.getCost());
		productRepository.save(product);
		return product;
	}

	@Override
	public Product update(ProductDto dto) {
		Optional<Product> productOp = productRepository.findById(dto.getId());
		if (productOp.isPresent()) {
			Product product = productOp.get();
			product.setName(!dto.getName().isEmpty() || !dto.getName().isBlank() ? dto.getName() : product.getName());
			product.setCost((dto.getCost() != null) ? dto.getCost() : product.getCost());
			productRepository.save(product);
			return product;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			productRepository.delete(product.get());
		}
	}

}
