package com.tqi.evolutionfullstack.livrariabackend.model;

import javax.persistence.*;
import java.io.Serializable;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tbl_book_stock")
public class BookStock implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Book bookId;

    @Column
    private Double costPrice;

    @Column
    private Double sellPrice;

    @Column
    private Integer quantity;

    public BookStock() {
    }

    public BookStock(Book bookId, Double costPrice, Double sellPrice, Integer quantity) {
        this.bookId = bookId;
        this.costPrice = costPrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookStock bookStock = (BookStock) o;
        return Objects.equals(bookId, bookStock.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }
}
