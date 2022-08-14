package com.tqi.evolutionfullstack.livrariabackend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tbl_customer_order")
public class CustomerOrder implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private Integer amount;
        private Double  price;



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

        public Double getPrice() {
                return price;
        }

        public void setPrice(Double price) {
                this.price = price;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                CustomerOrder that = (CustomerOrder) o;
                return Objects.equals(id, that.id);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id);
        }
}
