package com.tqi.evolutionfullstack.livrariabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "tab_customer")
public class CustomerOrder {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer	customerOrderId;
        @Column
        private Integer	customerId;
        @Column
        private String bookId;
        @Column
        private String amount;
        @Column
        private Double price;

        public Integer getCustomerId() {
                return customerId;
        }

        public void setCustomerId(Integer customerId) {
                this.customerId = customerId;
        }

        public String getBookId() {
                return bookId;
        }

        public void setBookId(String bookId) {
                this.bookId = bookId;
        }

        public String getAmount() {
                return amount;
        }

        public void setAmount(String amount) {
                this.amount = amount;
        }

        public Double getPrice() {
                return price;
        }

        public void setPrice(Double price) {
                this.price = price;
        }
}
