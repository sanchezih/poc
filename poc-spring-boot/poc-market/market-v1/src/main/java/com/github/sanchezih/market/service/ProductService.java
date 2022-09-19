package com.github.sanchezih.market.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sanchezih.market.domain.Product;
import com.github.sanchezih.market.domain.repository.RProduct;

@Service
public class ProductService implements IProduct {

	@Autowired
	RProduct rProduct;

	@Override
	public Product get() {
		Product product = new Product("Azucar", new BigDecimal(23.50));
		rProduct.save(product);
		return product;
	}

}
