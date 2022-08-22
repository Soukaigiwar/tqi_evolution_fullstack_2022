package com.tqi.evolutionfullstack.livrariabackend.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "tbl_customer")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column(name = "name", length = 100)
        private String  name;
        @Column(name = "cpf", length = 14)
        private String	cpf;
}
