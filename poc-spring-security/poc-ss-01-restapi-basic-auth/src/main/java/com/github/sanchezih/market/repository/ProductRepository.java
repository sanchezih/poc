package com.github.sanchezih.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.sanchezih.market.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
