package com.github.sanchezih.pocwebfluxbook.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.sanchezih.pocwebfluxbook.dao.BookRepository;
import com.github.sanchezih.pocwebfluxbook.model.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

	private final BookRepository bookRepository;

	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Flux<Book> getAllBook() {
		return bookRepository.findAll().log().delayElements(Duration.ofSeconds(1));
	}

	public Flux<Book> getAllBookBackPresure(int limitRequest) {
		Flux<Book> bookFlux = bookRepository.findAll().delayElements(Duration.ofSeconds(1)).log();
		return bookFlux.limitRate(limitRequest);
	}

	public Mono<Book> findById(Long id) {
		return bookRepository.findById(id);
	}

	public Mono<Book> postBook(Book book) {
		return bookRepository.save(book).log();
	}

	public Mono<ResponseEntity<Book>> updateBook(Long id, Book book) {
		return bookRepository.findById(id).flatMap(oldBook -> {
			oldBook.setTitle(book.getTitle());
			oldBook.setAuthor(book.getAuthor());
			return bookRepository.save(oldBook);
		}).map(updatedBook -> new ResponseEntity<>(updatedBook, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.OK));
	}

	public Mono<Book> deleteUser(long id) {
		return bookRepository.findById(id)
				.flatMap(deletedBook -> bookRepository.delete(deletedBook).then(Mono.just(deletedBook)));
	}
}
