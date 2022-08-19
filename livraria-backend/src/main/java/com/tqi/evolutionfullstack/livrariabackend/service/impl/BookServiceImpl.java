package com.tqi.evolutionfullstack.livrariabackend.service.impl;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.BookService;
import org.springframework.data.domain.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;


    @Override
    @Transactional
    public Book SaveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    @Transactional
    public Book updateBook(Book book) {
        Objects.requireNonNull(book.getId());
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public void deleteBook(Book book) {
        Objects.requireNonNull(book.getId());
        bookRepository.delete(book);
    }

    @Override
    @Transactional
    public List<Book> listBook(Book bookId) {
        Example example = Example.of(bookId);
        return bookRepository.findAll(example);
    }
}
