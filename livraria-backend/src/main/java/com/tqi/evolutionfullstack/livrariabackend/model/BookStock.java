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
    private Long id;

    @Column
    private List bookId;

    @Column
    private Double costPrice;

    @Column
    private Double sellPrice;

    @Column
    private Integer quantity;

    public BookStock() {
    }

    public BookStock(List bookId, Double costPrice, Double sellPrice, Integer quantity) {
        this.bookId = bookId;
        this.costPrice = costPrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
    }

    public List getBookId() {
        return bookId;
    }

    public void setBookId(List bookId) {
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
