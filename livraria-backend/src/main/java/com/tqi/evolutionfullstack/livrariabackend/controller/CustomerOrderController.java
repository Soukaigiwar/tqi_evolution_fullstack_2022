package com.tqi.evolutionfullstack.livrariabackend.controller;

import com.tqi.evolutionfullstack.livrariabackend.dto.NewCustomerOrder;
import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import com.tqi.evolutionfullstack.livrariabackend.model.CustomerOrder;
import com.tqi.evolutionfullstack.livrariabackend.repository.CustomerOrderRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.PastOrPresent;
import java.util.List;

@RestController
@RequestMapping("/customer_order")
public class CustomerOrderController {

    private final CustomerOrderRepository customerOrderRepository;

    public CustomerOrderController(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    @Autowired
    private CustomerOrderRepository repository;
    @Autowired
    CustomerOrderService service;
    @GetMapping
    public List<CustomerOrder> findAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public CustomerOrder findById(@PathVariable Long id) {
        var customerOrderOptional = repository.findById(id);
        if (customerOrderOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return customerOrderOptional.get();
    }
    @PostMapping("/{id}")
    public void save(@RequestBody NewCustomerOrder order) { service.save(order);}
}
