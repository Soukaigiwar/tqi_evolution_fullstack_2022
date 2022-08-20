package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer SaveCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    List<Customer> listCustomer(Customer customerId);

    List<Customer> findAll();

    boolean EvaluateFields(Customer customer);

    Optional<Customer> getCustomerById(Long id);
}
