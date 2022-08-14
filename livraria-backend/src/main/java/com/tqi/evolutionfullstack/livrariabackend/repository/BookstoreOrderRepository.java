package com.tqi.evolutionfullstack.livrariabackend.repository;

import com.tqi.evolutionfullstack.livrariabackend.model.BookstoreOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookstoreOrderRepository extends JpaRepository<BookstoreOrder, Long> {

}
