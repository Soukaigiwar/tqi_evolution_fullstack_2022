package com.tqi.evolutionfullstack.livrariabackend.repository;

import com.tqi.evolutionfullstack.livrariabackend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
