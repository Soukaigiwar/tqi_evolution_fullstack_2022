package com.tqi.evolutionfullstack.livrariabackend.controller;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public void save(@RequestBody Book book) {
        service.save(book);
    }
}
