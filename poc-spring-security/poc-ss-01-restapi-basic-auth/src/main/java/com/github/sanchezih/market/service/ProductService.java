package com.github.sanchezih.market.service;

import java.util.List;

import com.github.sanchezih.market.dto.ProductDto;
import com.github.sanchezih.market.entity.Product;

public interface ProductService {
	
	public List<Product> getAll();
	
	public Product get(Long id);

	public Product create(ProductDto dto);

	public Product update(ProductDto dto);

	public void delete(Long id);
}
