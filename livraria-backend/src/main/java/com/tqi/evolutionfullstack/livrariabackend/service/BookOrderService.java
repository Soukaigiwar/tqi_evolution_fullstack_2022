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
        BookOrder book = new BookOrder();
        book.setBookId(newBookOrder.getBookId());
        book.setAmount(newBookOrder.getAmount());
        book.setPrice(newBookOrder.getPrice());

        repository.save(book);
    }
}
