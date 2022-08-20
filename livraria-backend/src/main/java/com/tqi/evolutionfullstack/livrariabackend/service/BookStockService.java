package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.model.BookStock;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookStockService {

    List<BookStock> findAll();

    BookStock save(BookStock bookStock);




//    public List<BookStock> findAll() {
//        return bookStockRepository.findAll();
//    }

//    public void save(BookStock bookStock) {
//        BookStock objBookStock = new BookStock();
//        objBookStock.setBookId(bookStock.getBookId());
//        objBookStock.setCostPrice(bookStock.getCostPrice());
//        objBookStock.setSellPrice(bookStock.getSellPrice());
//        objBookStock.setQuantity(bookStock.getQuantity());
//
//        bookStockRepository.save(objBookStock);
//    }
}
