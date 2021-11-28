package com.github.sanchezih.pocwebfluxbook.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.github.sanchezih.pocwebfluxbook.handler.BookHandler;

@Configuration
public class BookRouter {

	@Bean
	public RouterFunction<ServerResponse> bookRouterFunc(BookHandler bookHandler) {
		return RouterFunctions
				.route(GET("/api/func/books/").and(accept(MediaType.TEXT_EVENT_STREAM)), bookHandler::getAllBooks)
				.andRoute(GET("/api/func/books/" + "{id}").and(accept(MediaType.APPLICATION_JSON)),
						bookHandler::getOneBook)
				.andRoute(POST("/api/func/books/").and(accept(MediaType.APPLICATION_JSON)), bookHandler::createBook)
				.andRoute(DELETE("/api/func/books/" + "{id}").and(accept(MediaType.APPLICATION_JSON)),
						bookHandler::deleteBook)
				.andRoute(PUT("/api/func/books/" + "{id}").and(accept(MediaType.APPLICATION_JSON)),
						bookHandler::updateBook);

	}

}
