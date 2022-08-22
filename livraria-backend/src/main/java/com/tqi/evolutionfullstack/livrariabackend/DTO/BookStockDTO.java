package com.tqi.evolutionfullstack.livrariabackend.DTO;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.repository.BookRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.BookService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookStockDTO {

    private Long id;
    private Long bookId;
    private Double costPrice;
    private Double sellPrice;
    private Integer quantity;
}
