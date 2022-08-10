package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.dto.NewCustomer;
import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import com.tqi.evolutionfullstack.livrariabackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public void save(NewCustomer newCustomer) {
        Customer customer = new Customer();

        customer.setCpf(newCustomer.getCpf());
        customer.setName(newCustomer.getName());

//        Conta conta = new Conta();
//        conta.setSaldo(0.0);
//        conta.setNumero(new Date().getTime());

//        correntista.setConta(conta);
        repository.save(customer);
    }
}
