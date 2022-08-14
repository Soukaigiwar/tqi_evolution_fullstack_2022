package com.tqi.evolutionfullstack.livrariabackend.controller;

import com.tqi.evolutionfullstack.livrariabackend.model.BookstoreOrder;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookstoreOrderRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.BookstoreOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/book_order")
public class BookstoreOrderController {

    @Autowired
    private BookstoreOrderRepository repository;
    @Autowired
    BookstoreOrderService service;

    @GetMapping
    public List<BookstoreOrder> findAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public BookstoreOrder findById(@PathVariable Long id) {
        var bookOrderOptional = repository.findById(id);
        if (bookOrderOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return bookOrderOptional.get();
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createBookOrder(@RequestBody BookstoreOrder bookstoreOrder) {
        service.save(bookstoreOrder);
    }
}
