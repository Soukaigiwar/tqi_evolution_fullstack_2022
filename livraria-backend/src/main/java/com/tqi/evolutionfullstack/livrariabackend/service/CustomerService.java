package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import com.tqi.evolutionfullstack.livrariabackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void save(Customer customer) {
        Customer objCustomer = new Customer();
        objCustomer.setCpf(customer.getCpf());
        objCustomer.setName(customer.getName());

        customerRepository.save(objCustomer);
    }
}
