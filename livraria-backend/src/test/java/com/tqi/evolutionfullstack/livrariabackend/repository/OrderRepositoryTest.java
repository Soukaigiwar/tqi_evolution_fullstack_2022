package com.tqi.evolutionfullstack.livrariabackend.repository;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.model.Order;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static com.tqi.evolutionfullstack.livrariabackend.model.enums.OrderTypeEnum.BUY;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void mustSaveAnOrder() {
        Order order = orderBuilder();

        order = orderRepository.save(order);

        Assertions.assertNotNull(order);
    }

    @Test
    public void mustDeleteAOrder() {
        Order order = orderBuilder();

        entityManager.persist(order);
        order = entityManager.find(Order.class, order.getId());

        orderRepository.delete(order);

        Order orderNotFound = entityManager.find(Order.class, order.getId());
        Assertions.assertNull(orderNotFound);
    }

    @Test
    public void mustFindAOrderById() {
        Order order = orderBuilder();

        entityManager.persist(order);
        Order orderFound = entityManager.find(Order.class, order.getId());
        Assertions.assertNotNull(orderFound);
    }



    public static Order orderBuilder() {

        return Order.builder()
                .id(1L)
                .amount(1)
                .orderType(BUY)
                .costPrice(1.0)
                .sellPrice(2.0)
                .book(Book.builder()
                        .id(1L)
                        .title("L")
                        .author("A")
                        .publisher("P")
                        .img("I")
                        .publishedYear(2000)
                        .costPrice(15.0)
                        .sellPrice(23.99)
                        .quantity(12)
                        .build())
                .build();
    }

    public static Book bookBuilder() {

        return Book.builder()
                .id(1L)
                .title("O Senhor dos Anéis - A Sociedade do Anel")
                .author("JRR Tolkien")
                .publisher("Martins Fontes")
                .img("https://upload.wikimedia.org/wikipedia/pt/2/26/Asociedadedoanel.jpg")
                .publishedYear(2000)
                .costPrice(15.0)
                .sellPrice(23.99)
                .quantity(12)
                .build();
    }
}