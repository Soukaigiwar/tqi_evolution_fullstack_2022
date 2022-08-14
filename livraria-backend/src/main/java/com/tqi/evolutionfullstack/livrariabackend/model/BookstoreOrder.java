package com.tqi.evolutionfullstack.livrariabackend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_bookstore_order")
public class BookstoreOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Integer amount;
    @Column
    private Double cost;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book books;

    public BookstoreOrder() {
    }

    public BookstoreOrder(Long id, Book book, Integer amount, Double cost) {
        this.id = id;
        this.books = book;
        this.amount = amount;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return books;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double price) {
        this.cost = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookstoreOrder that = (BookstoreOrder) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
