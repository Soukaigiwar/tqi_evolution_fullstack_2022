package com.tqi.evolutionfullstack.livrariabackend.DTO;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDTO {

    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String img;
    private Integer publishedYear;
    private Double costPrice;
    private Double sellPrice;
    private Integer quantity;
}
