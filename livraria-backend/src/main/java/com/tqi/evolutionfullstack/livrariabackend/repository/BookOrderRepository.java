package com.tqi.evolutionfullstack.livrariabackend.repository;

import com.tqi.evolutionfullstack.livrariabackend.model.BookOrder;
import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookOrderRepository extends JpaRepository<BookOrder, Long> { }
