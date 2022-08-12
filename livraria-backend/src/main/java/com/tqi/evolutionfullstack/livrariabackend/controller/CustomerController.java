package com.tqi.evolutionfullstack.livrariabackend.controller;

import com.tqi.evolutionfullstack.livrariabackend.dto.NewCustomer;
import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import com.tqi.evolutionfullstack.livrariabackend.repository.CustomerRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    CustomerService service;

    @GetMapping("/{$id}")
    public List<Customer> findById() {
        return repository.findAll();
    }
    @GetMapping
    public List<Customer> findAll() {
        return repository.findAll();
    }

//    @PostMapping("/customer/{$id}")
//    public void save(@RequestBody NewCustomer newCustomer) {
//        Customer customer = (Customer) CustomerRepository.save(newCustomer);
//    }

    @PostMapping("/{$id}")
    public void createCustomer(@RequestBody NewCustomer newCustomer) {
        Customer customer = repository.save(new Customer(newCustomer.getName(), newCustomer.getCpf()));
        customer.toString();
    }
}
