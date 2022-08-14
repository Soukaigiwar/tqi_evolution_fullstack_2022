package com.tqi.evolutionfullstack.livrariabackend.repository;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
//        Book book = new Book();
//        book.setTitle("Livro dois");
//        book.setAuthor("Autor dois");
//        book.setPublisher("Editora dois");
//        book.setImg("imagem url");
//        book.setPublishedYear(2000);
//        book.setCostPrice(BigDecimal.valueOf(20.90));
//        bookRepository.save(book);
    }
}
