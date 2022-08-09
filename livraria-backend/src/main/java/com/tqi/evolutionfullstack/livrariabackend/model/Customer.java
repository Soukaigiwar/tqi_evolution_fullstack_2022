package com.tqi.evolutionfullstack.livrariabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "tab_customer")
public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer	customerId;
        @Column(length = 20)
        private String	cpf;
        @Column(length = 60)
        private String name;

        public Integer getId() {
                return customerId;
        }

        public void setId(Integer id) {
                this.customerId = id;
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
