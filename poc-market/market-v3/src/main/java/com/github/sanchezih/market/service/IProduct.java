package com.github.sanchezih.market.service;

import com.github.sanchezih.market.domain.Product;
import com.github.sanchezih.market.dto.ProductDto;

public interface IProduct {
	public Product get(Long id);

	public Product create(ProductDto dto);

	public Product update(ProductDto dto);

	public void delete(Long id);
}
