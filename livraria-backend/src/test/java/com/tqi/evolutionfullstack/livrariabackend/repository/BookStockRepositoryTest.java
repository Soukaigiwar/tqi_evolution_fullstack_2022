package com.tqi.evolutionfullstack.livrariabackend.repository;

import com.tqi.evolutionfullstack.livrariabackend.model.BookStock;
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
public class BookStockRepositoryTest {

    @Autowired
    BookStockRepository bookStockRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void mustSaveABookStock() {
        BookStock bookStock = bookStockBuilder();

        bookStock = bookStockRepository.save(bookStock);

        Assertions.assertNotNull(bookStock);
    }

    @Test
    public void mustDeleteABookStock() {
        BookStock bookStock = bookStockBuilder();

        entityManager.persist(bookStock);
        bookStock = entityManager
                .find(BookStock.class, bookStock.getId());

        bookStockRepository.delete(bookStock);

        BookStock bookStockNotFound = entityManager
                .find(BookStock.class, bookStock.getId());
        Assertions.assertNull(bookStockNotFound);
    }

    @Test
    public void mustFindABookStockById() {
        BookStock book = bookStockBuilder();

        entityManager.persist(book);
        BookStock bookFound = entityManager.find(BookStock.class, book.getId());
        Assertions.assertNotNull(bookFound);
    }

    @Test
    public void mustUpdateABookStock() {
        BookStock bookStock = bookStockBuilder();

        bookStock = bookStockRepository.save(bookStock);

        bookStock = BookStock.builder()
                .id(1L)
                .bookId(1L)
                .costPrice(25.0)
                .sellPrice(33.99)
                .quantity(10)
                .build();

        bookStock = bookStockRepository.save(bookStock);

        Assertions.assertNotNull(bookStock);
    }

    public static BookStock bookStockBuilder() {

        return BookStock.builder()
                .bookId(1L)
                .costPrice(15.0)
                .sellPrice(23.99)
                .quantity(null)
                .build();
    }
}
