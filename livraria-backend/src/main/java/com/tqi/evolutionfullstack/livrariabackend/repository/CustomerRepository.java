package com.tqi.evolutionfullstack.livrariabackend.repository;

import com.tqi.evolutionfullstack.livrariabackend.model.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    @EntityGraph(attributePaths={"bookOrder", "bookOrder.book"})
//    Customer findCustomerById(Long id);
}
