package com.tqi.evolutionfullstack.livrariabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_customer")
public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column(length = 100)
        private String  name;
        @Column(length = 14)
        private String	cpf;
        public Customer() { }

        public Customer(Long id, String name, String cpf) {
                this.id = id;
                this.name = name;
                this.cpf = cpf;
        }

        // Getters and Setters
        public Long getId() {
                return id;
        }
        public void setId(Long id) {
                this.id = id;
        }
        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }
        public String getCpf() {
                return cpf;
        }
        public void setCpf(String cpf) {
                this.cpf = cpf;
        }
}
