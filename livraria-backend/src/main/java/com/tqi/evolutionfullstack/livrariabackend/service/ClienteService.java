package com.tqi.evolutionfullstack.livrariabackend.service;

import com.tqi.evolutionfullstack.livrariabackend.model.ClienteModel;

public interface ClienteService {

    Iterable<ClienteModel> findAllClients();

    ClienteModel findClientById(Long id);

    void insert(ClienteModel cliente);

    void update(Long id, ClienteModel cliente);

    void delete(Long id);

}
