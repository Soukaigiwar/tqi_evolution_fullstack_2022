package com.tqi.evolutionfullstack.livrariabackend.service;


import com.tqi.evolutionfullstack.livrariabackend.dto.NewCustomerOrder;
import com.tqi.evolutionfullstack.livrariabackend.model.CustomerOrder;
import com.tqi.evolutionfullstack.livrariabackend.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService {
    @Autowired
    private CustomerOrderRepository repository;

    public void save(NewCustomerOrder newCustomerOrder) {
        CustomerOrder order = new CustomerOrder();
        order.setCustomerOrderId(newCustomerOrder.getCustomerOrderId());
        order.setCustomerId(newCustomerOrder.getCustomerId());
        order.setBookId(newCustomerOrder.getBookId());
        order.setAmount(newCustomerOrder.getAmount());
        order.setPrice(newCustomerOrder.getPrice());

        repository.save(order);
    }
}
