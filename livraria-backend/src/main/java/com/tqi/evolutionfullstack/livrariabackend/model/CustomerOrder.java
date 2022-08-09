package com.tqi.evolutionfullstack.livrariabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "tab_customer")
public class CustomerOrder {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long	customerOrderId;
        @Column
        private Long	customerId;
        @Column
        private Long    bookId;
        @Column
        private Integer amount;
        @Column
        private Double  price;

        public Long getCustomerOrderId() {
                return customerOrderId;
        }

        public void setCustomerOrderId(Long customerOrderId) {
                this.customerOrderId = customerOrderId;
        }

        public Long getCustomerId() {
                return customerId;
        }

        public void setCustomerId(Long customerId) {
                this.customerId = customerId;
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
