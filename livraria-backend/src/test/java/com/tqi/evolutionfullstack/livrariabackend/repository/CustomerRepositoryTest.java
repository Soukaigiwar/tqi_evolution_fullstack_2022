package com.tqi.evolutionfullstack.livrariabackend.repository;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
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
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;
    
    @Autowired
    TestEntityManager entityManager;

    @Test
    public void mustSaveACustomer() {
        Customer customer = customerBuilder();

        customer = customerRepository.save(customer);

        Assertions.assertNotNull(customer);
    }

    @Test
    public void mustDeleteACustomer() {
        Customer customer = customerBuilder();

        entityManager.persist(customer);
        customer = entityManager.find(Customer.class, customer.getId());

        customerRepository.delete(customer);

        Customer bookNotFound = entityManager.find(Customer.class, customer.getId());
        Assertions.assertNull(bookNotFound);
    }

    @Test
    public void mustFindACustomerById() {
        Customer customer = customerBuilder();

        entityManager.persist(customer);
        Customer customerFound = entityManager.find(Customer.class, customer.getId());
        Assertions.assertNotNull(customerFound);
    }

    public static Customer customerBuilder() {

        return Customer.builder()
                .id(1L)
                .name("Sergio Mello")
                .cpf("11122233344")
                .build();
    }
}
