package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import com.tqi.evolutionfullstack.livrariabackend.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {

    List<Order> findAll();

    List<Order> listOrder(Order orderId);

    Order save(Order order);

}
