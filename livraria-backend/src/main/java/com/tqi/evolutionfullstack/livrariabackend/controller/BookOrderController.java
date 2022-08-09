package com.tqi.evolutionfullstack.livrariabackend.controller;

import com.tqi.evolutionfullstack.livrariabackend.dto.NewBookOrder;
import com.tqi.evolutionfullstack.livrariabackend.model.BookOrder;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookOrderRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book_order")
public class BookOrderController {

    @Autowired
    private BookOrderRepository repository;
    @Autowired
    BookOrderService service;

    @GetMapping
    public List<BookOrder> findAll() { return repository.findAll(); }

    @PostMapping
    public  void save(@RequestBody NewBookOrder book) { service.save(book);}
}
