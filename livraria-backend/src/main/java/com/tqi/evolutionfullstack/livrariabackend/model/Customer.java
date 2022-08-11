package com.tqi.evolutionfullstack.livrariabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "tab_customer")
public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column(length = 100)
        private String  name;
        @Column(length = 14)
        private String	cpf;

        public Customer() { }
        public Customer(String name, String cpf) {
                this.name = name;
                this.cpf = cpf;
        }

        public Long getId() {
                return id;
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

        @Override
        public String toString() {
                return "Customer [id=" + id + ", name=" + name + ", cpf=" + cpf + "]";
        }

        //        public Order getOrder() {
//                return order;
//        }
//
//        public void setOrder(Order order) {
//                this.order = order;
//        }
}
