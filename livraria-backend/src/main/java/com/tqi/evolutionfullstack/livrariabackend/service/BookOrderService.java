package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.dto.NewBookOrder;
import com.tqi.evolutionfullstack.livrariabackend.model.BookOrder;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookOrderService {

    @Autowired
    private BookOrderRepository repository;

    public void save(NewBookOrder newBookOrder){
        BookOrder bookOrder = new BookOrder();
        bookOrder.setBookId(newBookOrder.getBookId());
        bookOrder.setAmount(newBookOrder.getAmount());
        bookOrder.setPrice(newBookOrder.getPrice());

        repository.save(bookOrder);
    }
}
