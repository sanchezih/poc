package com.github.sanchezih.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.sanchezih.products.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
