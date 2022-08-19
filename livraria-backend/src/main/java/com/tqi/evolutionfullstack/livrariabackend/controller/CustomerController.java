package com.tqi.evolutionfullstack.livrariabackend.controller;

import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import com.tqi.evolutionfullstack.livrariabackend.repository.CustomerRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    CustomerService service;

    @GetMapping
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) {
        var customerOptional = repository.findById(id);
        if (customerOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return customerOptional.get();
    }

//    @PostMapping
//    @ResponseStatus(code = HttpStatus.CREATED)
//    //@CrossOrigin(origins = "http://localhost:8080")
//    public void createCustomer(@RequestBody Customer customer) {
//        Customer objCustomer = repository.save(new Customer(customer.getId(), customer.getName(), customer.getCpf()));
//
//    }
}
