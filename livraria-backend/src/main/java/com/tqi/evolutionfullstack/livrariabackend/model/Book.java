package com.tqi.evolutionfullstack.livrariabackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tbl_book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50)
    private String title;
    @Column(length = 50)
    private String  author;
    @Column(length = 30)
    private String  publisher;
    @Column(length = 255)
    private String  img;
    @Column
    private Integer publishedYear;
    @Column
    private Double costPrice;
    @Column
    private Double sellPrice;
    @Column
    private Integer quantity;
}
