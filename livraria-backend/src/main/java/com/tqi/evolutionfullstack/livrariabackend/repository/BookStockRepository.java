package com.tqi.evolutionfullstack.livrariabackend.repository;

import com.tqi.evolutionfullstack.livrariabackend.model.BookStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStockRepository extends JpaRepository<BookStock, Long> {
}
