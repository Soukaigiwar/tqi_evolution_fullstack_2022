package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book SaveBook(Book book);

    Optional<Book> getBookById(Long id);

    void deleteBook(Book book);

    List<Book> listBook( Book bookId );

    List<Book> findAll();
}
