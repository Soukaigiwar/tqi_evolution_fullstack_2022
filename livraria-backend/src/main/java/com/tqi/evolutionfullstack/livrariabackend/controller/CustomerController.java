package com.tqi.evolutionfullstack.livrariabackend.controller;

import com.tqi.evolutionfullstack.livrariabackend.DTO.CustomerDTO;
import com.tqi.evolutionfullstack.livrariabackend.exception.BookstoreRulesException;
import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import com.tqi.evolutionfullstack.livrariabackend.repository.CustomerRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Customer>> findAll() {
            List<Customer> list = service.findAll();
            return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) {
        var customerOptional = repository.findById(id);
        if (customerOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return customerOptional.get();
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto) {
        try {
            Customer customer = returnDTO(dto);
            customer = service.SaveCustomer(customer);
            return ResponseEntity.ok(customer);
        } catch (BookstoreRulesException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer( @PathVariable("id") Long id) {
        return service.getCustomerById(id).map( entity -> {
            service.deleteCustomer(entity);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }).orElseGet( () -> new ResponseEntity("Cliente não encontrado.", HttpStatus.NOT_FOUND));
    }

    private Customer returnDTO(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setCpf(dto.getCpf());

        return customer;
    }

//    @PostMapping
//    @ResponseStatus(code = HttpStatus.CREATED)
//    //@CrossOrigin(origins = "http://localhost:8080")
//    public void createCustomer(@RequestBody Customer customer) {
//        Customer objCustomer = repository.save(new Customer(customer.getId(), customer.getName(), customer.getCpf()));
//
//    }
}
