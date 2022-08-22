package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.exception.BookstoreRulesException;
import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.model.Order;
import com.tqi.evolutionfullstack.livrariabackend.model.enums.OrderTypeEnum;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookRepositoryTest;
import com.tqi.evolutionfullstack.livrariabackend.repository.OrderRepository;
import com.tqi.evolutionfullstack.livrariabackend.repository.OrderRepositoryTest;
import com.tqi.evolutionfullstack.livrariabackend.service.impl.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class OrderServiceTest {

    @SpyBean
    OrderServiceImpl service;

    @MockBean
    OrderRepository repository;

    @Test
    public void shouldSaveAnOrder() {
        Order orderToSave = OrderRepositoryTest.orderBuilder();
        Order orderSaved = OrderRepositoryTest.orderBuilder();

        Mockito.when(repository.save(orderToSave)).thenReturn(orderSaved);
        service.save(orderToSave);

        Assertions.assertThat(orderToSave.getId()).isEqualTo(orderSaved.getId());
        Assertions.assertThat(orderSaved.getOrderType()).isEqualTo(orderToSave.getOrderType());
    }

    @Test
    public void shouldNotSaveAnOrderWhenValidationErrorsOccours() {
        Order orderToSave = OrderRepositoryTest.orderBuilder();
        Mockito.doThrow(BookstoreRulesException.class).when(service).save(orderToSave);

        Assertions.catchThrowableOfType( () -> service
                .save(orderToSave), BookstoreRulesException.class);
        Mockito.verify(repository, Mockito.never()).save(orderToSave);
    }

    @Test
    public void shouldFilterAnOrder() {
        Order order = OrderRepositoryTest.orderBuilder();
        order.setId(1L);

        List<Order> list = Arrays.asList(order);
        Mockito.when(repository.findAll(Mockito.any(Example.class))).thenReturn(list);

        List<Order> result = service.listOrder(order);

        Assertions.assertThat(result)
                .isNotEmpty()
                .hasSize(1)
                .contains(order);
    }
}
