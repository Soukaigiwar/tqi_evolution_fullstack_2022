package com.tqi.evolutionfullstack.livrariabackend.controller;

import com.tqi.evolutionfullstack.livrariabackend.dto.NewBookOrder;
import com.tqi.evolutionfullstack.livrariabackend.model.BookOrder;
import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookOrderRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/{id}")
    public BookOrder findById(@PathVariable Long id) {
        var bookOrderOptional = repository.findById(id);
        if (bookOrderOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return bookOrderOptional.get();
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createBookOrder(@RequestBody NewBookOrder bookOrder) {
        //BookOrder bookOrder1 = repository
        service.save(bookOrder);
    }
}
