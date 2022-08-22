package com.tqi.evolutionfullstack.livrariabackend.service.impl;

import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import com.tqi.evolutionfullstack.livrariabackend.model.Order;
import com.tqi.evolutionfullstack.livrariabackend.repository.OrderRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.tqi.evolutionfullstack.livrariabackend.model.enums.OrderTypeEnum.BUY;
import static com.tqi.evolutionfullstack.livrariabackend.model.enums.OrderTypeEnum.SELL;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public List<Order> listOrder(Order orderId) {
            Example example = Example.of(orderId);
            return orderRepository.findAll(example);
    }

    @Override
    @Transactional
    public Order save(Order order) {
        Order objOrder = new Order();

        objOrder.setOrderType(order.getOrderType());
        objOrder.setAmount(order.getAmount());
        if(order.getOrderType().equals(BUY)) {
            objOrder.setCostPrice(order.getCostPrice());
            objOrder.setSellPrice(order.getSellPrice());
        }
        else if (order.getOrderType().equals(SELL))
            objOrder.setSellPrice(order.getSellPrice());
        objOrder.setId(order.getBook().getId());

        orderRepository.save(objOrder);
        return null;
    }
}
