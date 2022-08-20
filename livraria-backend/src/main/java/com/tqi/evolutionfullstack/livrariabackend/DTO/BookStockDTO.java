package com.tqi.evolutionfullstack.livrariabackend.DTO;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookStockDTO {

    private Long id;
    private Book bookId;
    private Double costPrice;
    private Double sellPrice;
    private Integer quantity;
}
