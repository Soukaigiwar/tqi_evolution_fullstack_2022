package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.dto.NewBook;
import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public void save(NewBook newBook){
        Book book = new Book();
        book.setTitle(newBook.getTitle());
        book.setAuthor(newBook.getAuthor());
        book.setPublisher(newBook.getPublisher());
        book.setImg(newBook.getImg());
        book.setPublishedDate(book.getPublishedDate());

        repository.save(book);
    }


}
