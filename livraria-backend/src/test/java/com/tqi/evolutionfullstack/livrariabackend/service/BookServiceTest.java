package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.exception.BookstoreRulesException;
import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookRepository;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookRepositoryTest;
import com.tqi.evolutionfullstack.livrariabackend.repository.CustomerRepositoryTest;
import com.tqi.evolutionfullstack.livrariabackend.service.impl.BookServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class BookServiceTest {

    @SpyBean
    BookServiceImpl service;
    @MockBean
    BookRepository repository;

    @Test
    public void mustSaveABook() {
        Book bookToSave = BookRepositoryTest.bookBuilder();
        Book bookSaved = BookRepositoryTest.bookBuilder();
        bookSaved.setId(1L);

        Mockito.when(repository.save(bookToSave)).thenReturn(bookSaved);
        Book book = service.SaveBook(bookToSave);

        Assertions.assertThat(book.getId()).isEqualTo(bookSaved.getId());
    }

    @Test
    public void dontMustSaveABookWhenValidationErrorsOccours() {
        Book bookToSave = BookRepositoryTest.bookBuilder();
        Mockito.doThrow(BookstoreRulesException.class).when(service).SaveBook(bookToSave);

        Assertions.catchThrowableOfType( () -> service
                        .SaveBook(bookToSave), BookstoreRulesException.class);
        Mockito.verify(repository, Mockito.never()).save(bookToSave);
    }

    @Test
    public void shouldDeleteABook() {
        Book book = BookRepositoryTest.bookBuilder();
        book.setId(1L);

        service.deleteBook(book);

        Mockito.verify(repository).delete(book);
    }

    @Test
    public void shouldNotDeleteABookThatHasNotYetBeenSaved() {
        Book book = BookRepositoryTest.bookBuilder();

        Assertions.catchThrowableOfType( () -> service
                .deleteBook(book), NullPointerException.class);
        Mockito.verify(repository, Mockito.never()).delete(book);

    }

    @Test
    public void shouldFilterABook() {
        Book book = BookRepositoryTest.bookBuilder();
        book.setId(1L);

        List<Book> list = Arrays.asList(book);
        Mockito.when(repository.findAll(Mockito.any(Example.class))).thenReturn(list);

        List<Book> result = service.listBook(book);

        Assertions.assertThat(result)
                .isNotEmpty()
                .hasSize(1)
                .contains(book);
    }

}
