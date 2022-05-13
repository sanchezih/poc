package com.github.sanchezih.market.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sanchezih.market.domain.Product;
import com.github.sanchezih.market.domain.repository.RProduct;
import com.github.sanchezih.market.dto.ProductDto;

@Service
public class ProductService implements IProduct {

	@Autowired
	RProduct rProduct;

	@Override
	public Product get(Long id) {
		Optional<Product> product = rProduct.findById(id);
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
		rProduct.save(product);
		return product;
	}

	@Override
	public Product update(ProductDto dto) {
		Optional<Product> productOp = rProduct.findById(dto.getId());
		if (productOp.isPresent()) {
			Product product = productOp.get();
			product.setName(!dto.getName().isEmpty() || !dto.getName().isBlank() ? dto.getName() : product.getName());
			product.setCost((dto.getCost() != null) ? dto.getCost() : product.getCost());
			rProduct.save(product);
			return product;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Optional<Product> product = rProduct.findById(id);
		if (product.isPresent()) {
			rProduct.delete(product.get());
		}
	}

}
