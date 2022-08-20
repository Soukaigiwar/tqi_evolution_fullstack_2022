package com.tqi.evolutionfullstack.livrariabackend.model;

import com.tqi.evolutionfullstack.livrariabackend.DTO.BookListDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_book_stock")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookStock implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private BookListDTO bookId;

    @Column
    private Double costPrice;

    @Column
    private Double sellPrice;

    @Column
    private Integer quantity;
}
