package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookService {

    Book SaveBook(Book book);

    Optional<Book> getBookById(Long id);

    Book updateBook(Book book);

    void deleteBook(Book book);

    List<Book> listBook( Book bookId );

}
