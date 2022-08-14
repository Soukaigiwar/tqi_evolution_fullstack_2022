package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.model.CustomerOrder;
import com.tqi.evolutionfullstack.livrariabackend.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    public void save(CustomerOrder customerOrder) {
        CustomerOrder objOrder = new CustomerOrder();
        objOrder.setId(customerOrder.getId());
        objOrder.setAmount(customerOrder.getAmount());
        objOrder.setPrice(customerOrder.getPrice());

        customerOrderRepository.save(objOrder);
    }
}
