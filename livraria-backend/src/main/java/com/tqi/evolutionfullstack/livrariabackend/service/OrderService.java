package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.model.Order;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookRepository;
import com.tqi.evolutionfullstack.livrariabackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.tqi.evolutionfullstack.livrariabackend.enums.OrderTypeEnum.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    public List<Order> findall() { return orderRepository.findAll(); }
    public void save(Order order) {
        Order objOrder = new Order();
        Book objBook = new Book();

        objOrder.setOrderType(order.getOrderType());
        objOrder.setAmount(order.getAmount());
        if(order.getOrderType().equals(BUY)) {
            objOrder.setCostPrice(order.getCostPrice());
            objOrder.setSellPrice(order.getSellPrice());
        }
        else if (order.getOrderType().equals(SELL))
            objOrder.setSellPrice(order.getSellPrice());
        objOrder.setBookId(order.getBookId());

        orderRepository.save(objOrder);
    }


}
