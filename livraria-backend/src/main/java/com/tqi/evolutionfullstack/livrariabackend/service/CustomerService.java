package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.model.Customer;

public interface CustomerService {
    Customer SaveCustomer(Customer customer);
    void EvaluateCPF(String cpf);
}
