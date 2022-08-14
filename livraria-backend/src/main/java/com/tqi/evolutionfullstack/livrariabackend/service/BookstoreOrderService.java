package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.model.BookstoreOrder;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookstoreOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreOrderService {

    @Autowired
    private BookstoreOrderRepository repository;

    public void save(BookstoreOrder BookstoreOrder){
        BookstoreOrder objBookstoreOrder = new BookstoreOrder();
        objBookstoreOrder.setAmount(BookstoreOrder.getAmount());
        objBookstoreOrder.setCost(BookstoreOrder.getCost());

        repository.save(objBookstoreOrder);
    }

    public List<BookstoreOrder> findAll() {
        return repository.findAll();
    }
}
