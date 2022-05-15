package com.github.sanchezih.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.sanchezih.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
