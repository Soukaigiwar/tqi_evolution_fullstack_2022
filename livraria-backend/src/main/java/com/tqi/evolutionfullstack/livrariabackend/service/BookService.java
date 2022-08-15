package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void save(Book book){
        Book objBook = new Book();

        objBook.setTitle(book.getTitle());
        objBook.setAuthor(book.getAuthor());
        objBook.setPublisher(book.getPublisher());
        objBook.setImg(book.getImg());
        objBook.setPublishedYear(book.getPublishedYear());
        objBook.setCostPrice(book.getCostPrice());
        objBook.setSellPrice((book.getSellPrice()));

        bookRepository.save(objBook);
    }

    public List<Book> findall() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        Optional<Book> obj = bookRepository.findById(id);
        if (obj.isEmpty()) {
            System.out.println("Erro: Nao foi encontrado com esse Id.");
            return null;
        }
        return obj.get();
    }
}
