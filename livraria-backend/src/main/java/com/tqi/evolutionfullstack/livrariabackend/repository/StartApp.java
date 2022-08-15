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
//        Book objBook = new Book();
//        objBook.setTitle("Livro dois");
//        objBook.setAuthor("Autor dois");
//        objBook.setPublisher("Editora dois");
//        objBook.setImg("imagem url");
//        objBook.setPublishedYear(2000);
//        objBook.setCostPrice((long) 20.50);
//        bookRepository.save(objBook);
    }
}
