package com.tqi.evolutionfullstack.livrariabackend.repository;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void mustSaveABook() {
        Book book = bookBuilder();

        book = bookRepository.save(book);

        Assertions.assertNotNull(book);
    }

    @Test
    public void mustDeleteABook() {
        Book book = bookBuilder();

        entityManager.persist(book);
        book = entityManager.find(Book.class, book.getId());

        bookRepository.delete(book);

        Book bookNotFound = entityManager.find(Book.class, book.getId());
        Assertions.assertNull(bookNotFound);
    }

    @Test
    public void mustFindABookById() {
        Book book = bookBuilder();

        entityManager.persist(book);
        Book bookFound = entityManager.find(Book.class, book.getId());
        Assertions.assertNotNull(bookFound);
    }

    public static Book bookBuilder() {

        return Book.builder()
                .title("O Senhor dos Anéis - A Sociedade do Anel")
                .author("JRR Tolkien")
                .publisher("Martins Fontes")
                .img("https://upload.wikimedia.org/wikipedia/pt/2/26/Asociedadedoanel.jpg")
                .publishedYear(2000)
                .costPrice(15.0)
                .sellPrice(23.99)
                .quantity(null)
                .build();
    }
}
