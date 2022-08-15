package com.tqi.evolutionfullstack.livrariabackend.controller;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository repository;
    @Autowired
    BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> list = service.findall();
        return ResponseEntity.ok().body(list);
    }
    @PostMapping
    public void save(@RequestBody Book objBook){
        service.save(objBook);
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        var bookOptional = repository.findById(id);
        if (bookOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return bookOptional.get();
    }
}
