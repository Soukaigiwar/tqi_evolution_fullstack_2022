package com.tqi.evolutionfullstack.livrariabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "tab_customer")
public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long	customerId;
        @Column(length = 14)
        private String	cpf;
        @Column(length = 100)
        private String name;

        public Long getCustomerId() {
                return customerId;
        }

        public void setCustomerId(Long customerId) {
                this.customerId = customerId;
        }

        public String getCpf() {
                return cpf;
        }

        public void setCpf(String cpf) {
                this.cpf = cpf;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        //        public Order getOrder() {
//                return order;
//        }
//
//        public void setOrder(Order order) {
//                this.order = order;
//        }
}
