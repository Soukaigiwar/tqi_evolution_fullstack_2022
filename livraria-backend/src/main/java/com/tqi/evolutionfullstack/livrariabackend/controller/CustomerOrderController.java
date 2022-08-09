package com.tqi.evolutionfullstack.livrariabackend.controller;

import com.tqi.evolutionfullstack.livrariabackend.dto.NewCustomerOrder;
import com.tqi.evolutionfullstack.livrariabackend.model.CustomerOrder;
import com.tqi.evolutionfullstack.livrariabackend.repository.CustomerOrderRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.PastOrPresent;
import java.util.List;

@RestController
@RequestMapping("/customer_order")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderRepository repository;
    @Autowired
    CustomerOrderService service;
    @GetMapping
    public List<CustomerOrder> findAll() { return repository.findAll(); }
    @PostMapping
    public void save(@RequestBody NewCustomerOrder order) { service.save(order);}
}
