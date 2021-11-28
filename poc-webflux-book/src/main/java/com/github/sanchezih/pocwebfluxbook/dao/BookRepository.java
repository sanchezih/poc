package com.github.sanchezih.pocwebfluxbook.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.github.sanchezih.pocwebfluxbook.model.Book;

public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
}