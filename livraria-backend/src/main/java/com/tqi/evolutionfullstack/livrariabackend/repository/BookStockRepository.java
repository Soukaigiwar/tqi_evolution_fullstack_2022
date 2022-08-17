package com.tqi.evolutionfullstack.livrariabackend.repository;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import com.tqi.evolutionfullstack.livrariabackend.model.BookStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookStockRepository extends JpaRepository<BookStock, Long> {
}
