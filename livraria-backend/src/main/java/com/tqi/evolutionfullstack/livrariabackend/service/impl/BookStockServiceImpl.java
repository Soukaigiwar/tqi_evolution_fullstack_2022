package com.tqi.evolutionfullstack.livrariabackend.service.impl;

import com.tqi.evolutionfullstack.livrariabackend.model.BookStock;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookRepository;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookStockRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.BookStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookStockServiceImpl implements BookStockService{

    @Autowired
    private BookStockRepository bookStockRepository;


    public List<BookStock> findAll() {
        return bookStockRepository.findAll();
    }

    @Override
    @Transactional
    public BookStock save(BookStock bookStock) {
        BookStock objBookStock = new BookStock();
        objBookStock.setBookId(bookStock.getBookId());
        objBookStock.setCostPrice(bookStock.getCostPrice());
        objBookStock.setSellPrice(bookStock.getSellPrice());
        objBookStock.setQuantity(bookStock.getQuantity());

        return bookStockRepository.save(bookStock);
    }
}
