package com.microservices.book.controller;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.book.contract.BookResource;
import com.microservices.book.contract.CreateBookRequest;
import com.microservices.book.repository.BookEntity;
import com.microservices.book.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {
	
	private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Collection<BookResource> get() {
        return repository.findAll().stream().map(BookResource::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity post(@RequestBody CreateBookRequest request) {
        repository.save(new BookEntity(request.getName()));
        return ResponseEntity.ok().build();
    }

}
