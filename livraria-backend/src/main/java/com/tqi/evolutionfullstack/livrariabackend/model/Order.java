package com.tqi.evolutionfullstack.livrariabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tqi.evolutionfullstack.livrariabackend.enums.OrderTypeEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer amount;
    @Column
    private OrderTypeEnum orderType;
    @Column
    private Double costPrice;

    private Double sellPrice;

//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customer;

    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public OrderTypeEnum getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderTypeEnum orderType) {
        this.orderType = orderType;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

//    public Book getBooks() {
//        return books;
//    }


    public Book getBook() {
        return book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
