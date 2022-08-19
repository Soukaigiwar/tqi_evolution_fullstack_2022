package com.tqi.evolutionfullstack.livrariabackend.service.impl;

import com.tqi.evolutionfullstack.livrariabackend.exception.RulesException;
import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import com.tqi.evolutionfullstack.livrariabackend.repository.CustomerRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        super();
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public Customer SaveCustomer(Customer customer) {
        EvaluateCPF(customer.getCpf());
        return customerRepository.save(customer);
    }

    @Override
    public void EvaluateCPF(String cpf) {
        boolean exist = customerRepository.existsByCPF(cpf);
        if(exist) {
            throw new RulesException("Já existe um usuário com esse CPF.");
        }
    }
}
