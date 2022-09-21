package com.github.sanchezih.market.service;

import java.util.List;

import com.github.sanchezih.market.dto.ProductDTO;
import com.github.sanchezih.market.entity.Product;

public interface ProductService {
	
	public List<Product> getAll();
	
	public Product get(Long id);

	public Product create(ProductDTO dto);

	public Product update(ProductDTO dto);

	public void delete(Long id);
}
