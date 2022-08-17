package com.tqi.evolutionfullstack.livrariabackend.controller;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.model.BookStock;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookRepository;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookStockRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.BookService;
import com.tqi.evolutionfullstack.livrariabackend.service.BookStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/book_stock")
public class BookStockController {

    @Autowired
    private BookStockRepository bookStockRepository;

    @Autowired
    BookStockService bookStockService;

    @GetMapping
    public ResponseEntity<List<BookStock>> findAll() {
        List<BookStock> list = bookStockService.findAll();
        return ResponseEntity.ok().body(list);
    }

//    @PostMapping
//    public void save(@RequestBody BookStock bookStock) {
//        bookStockService.save(bookStock);
//    }

}
