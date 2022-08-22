package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.exception.BookstoreRulesException;
import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookRepositoryTest;
import com.tqi.evolutionfullstack.livrariabackend.repository.CustomerRepository;
import com.tqi.evolutionfullstack.livrariabackend.repository.CustomerRepositoryTest;
import com.tqi.evolutionfullstack.livrariabackend.service.impl.CustomerServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.quality.MockitoHint;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class CustomerServiceTest {

    @SpyBean
    CustomerServiceImpl service;

    @MockBean
    CustomerRepository repository;

    @Test
    public void shouldSaveACustomer() {
        Customer customerToSave = CustomerRepositoryTest.customerBuilder();
        Customer customerSaved = CustomerRepositoryTest.customerBuilder();
        customerSaved.setId(1L);

        Mockito.when(repository.save(customerToSave)).thenReturn(customerSaved);
        Customer customer = service.SaveCustomer(customerToSave);

        Assertions.assertThat(customer.getId()).isEqualTo(customerSaved.getId());
    }

    @Test
    public void shouldNotSaveACustomerWhenValidationErrorsOccours() {
        Customer customerToSave = CustomerRepositoryTest.customerBuilder();
        Mockito.doThrow(BookstoreRulesException.class).when(service).SaveCustomer(customerToSave);

        Assertions.catchThrowableOfType( () -> service
                .SaveCustomer(customerToSave), BookstoreRulesException.class);
        Mockito.verify(repository, Mockito.never()).save(customerToSave);
    }

    @Test
    public void shouldDeleteACustomer() {
        Customer customer = CustomerRepositoryTest.customerBuilder();
        customer.setId(1L);

        service.deleteCustomer(customer);

        Mockito.verify(repository).delete(customer);
    }

    @Test
    public void shouldNotDeleteACustomerThatHasNotYetBeenSaved() {
        Customer customer = CustomerRepositoryTest.customerBuilder();

        Assertions.catchThrowableOfType( () -> service
                .deleteCustomer(customer), NullPointerException.class);
        Mockito.verify(repository, Mockito.never()).delete(customer);
    }

    @Test
    public void shouldFilterACustomer() {
        Customer customer = CustomerRepositoryTest.customerBuilder();
        customer.setId(1L);

        List<Customer> list = Arrays.asList(customer);
        Mockito.when(repository.findAll(Mockito.any(Example.class))).thenReturn(list);

        List<Customer> result = service.listCustomer(customer);

        Assertions.assertThat(result)
                .isNotEmpty()
                .hasSize(1)
                .contains(customer);
    }
}
