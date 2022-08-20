package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface BookService {

    Book SaveBook(Book book);

    Optional<Book> getBookById(Long id);

    //Book updateBook(Book book);

    void deleteBook(Book book);

    List<Book> listBook( Book bookId );

    List<Book> findAll();
}
