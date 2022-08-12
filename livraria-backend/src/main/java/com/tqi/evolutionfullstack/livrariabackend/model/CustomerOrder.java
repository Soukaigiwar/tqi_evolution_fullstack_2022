package com.tqi.evolutionfullstack.livrariabackend.model;

import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "tab_customer_order")
public class CustomerOrder {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "customerId", nullable = false)
        private Customer customer;
        @Column
        private Long    bookId;
        @Column
        private Integer amount;
        @Column
        private Double  price;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Customer getCustomer() {
                return customer;
        }

        public void setCustomer(Customer customer) {
                this.customer = customer;
        }

        public Long getBookId() {
                return bookId;
        }

        public void setBookId(Long bookId) {
                this.bookId = bookId;
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
}
