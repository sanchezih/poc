package com.github.sanchezih.market.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.sanchezih.market.domain.Product;

@Repository
public interface RProduct extends CrudRepository<Product, Long> {

}
