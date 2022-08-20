package com.tqi.evolutionfullstack.livrariabackend.service.impl;

import com.tqi.evolutionfullstack.livrariabackend.exception.BookstoreRulesException;
import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import com.tqi.evolutionfullstack.livrariabackend.repository.CustomerRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

//    public CustomerServiceImpl(CustomerRepository customerRepository) {
//        super();
//        this.customerRepository = customerRepository;
//    }

    @Override
    @Transactional
    public Customer SaveCustomer(Customer customer) {
        EvaluateFields(customer);
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(Customer customer) {
        Objects.requireNonNull(customer.getId());
        customerRepository.delete(customer);
    }

    @Override
    public boolean EvaluateFields(Customer customer) {
        System.out.println(customer.getCpf() + " | " + customer.getName());

        if(customer.getCpf().trim().equals(""))
            throw new BookstoreRulesException("Campo CPF vazio.");

        if(customer.getName().trim().equals(""))
            throw new BookstoreRulesException("Campo Nome vazio.");

        if(customerRepository.existsByCpf(customer.getCpf()))
            throw new BookstoreRulesException("CPF já cadastrado.");

        return false;
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Customer> listCustomer(Customer customerId) {
        Example example = Example.of(customerId);
        return customerRepository.findAll(example);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
