package com.tqi.evolutionfullstack.livrariabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "tab_book_order")
public class BookOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long bookId;
    @Column
    private Integer amount;
    @Column
    private Double price;


    public Long id() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
