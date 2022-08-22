package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.exception.BookstoreRulesException;
import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.model.BookStock;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookRepositoryTest;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookStockRepository;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookStockRepositoryTest;
import com.tqi.evolutionfullstack.livrariabackend.service.impl.BookStockServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class BookStockServiceTest {

    @SpyBean
    BookStockServiceImpl service;
    @MockBean
    BookStockRepository repository;

    @Test
    public void mustSaveABookStock() {
        BookStock bookStockToSave = BookStockRepositoryTest.bookStockBuilder();
        BookStock bookStockSaved = BookStockRepositoryTest.bookStockBuilder();
        bookStockSaved.setId(1L);

        Mockito.when(repository.save(bookStockToSave)).thenReturn(bookStockSaved);
        BookStock bookStock = service.save(bookStockToSave);

        Assertions.assertThat(bookStock.getId()).isEqualTo(bookStockSaved.getId());
    }

    @Test
    public void dontMustSaveABookStockWhenValidationErrorOccours() {
        BookStock bookStockToSave = BookStockRepositoryTest.bookStockBuilder();
        Mockito.doThrow(BookstoreRulesException.class).when(service).save(bookStockToSave);

        Assertions.catchThrowableOfType( () -> service
                .save(bookStockToSave), BookstoreRulesException.class);
        Mockito.verify(repository, Mockito.never()).save(bookStockToSave);
    }
}
