package com.tqi.evolutionfullstack.livrariabackend.service.implement;


import com.tqi.evolutionfullstack.livrariabackend.model.ClienteModel;
import com.tqi.evolutionfullstack.livrariabackend.repository.ClienteRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImplement implements ClienteService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Iterable<ClienteModel> findAllClients() {
        // Buscar todos os Clientes.
        return clienteRepository.findAll();
    }

    @Override
    public ClienteModel findClientById(Long id) {
        // Buscar Cliente por ID.
        Optional<ClienteModel> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void insert(ClienteModel cliente) {
        salvarClienteNovo(cliente.getId(), cliente);
    }

    @Override
    public void update(Long id, ClienteModel cliente) {
        // Buscar Cliente por ID, caso exista:
        Optional<ClienteModel> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteNovo(cliente.getId(), cliente);
        }
    }

    @Override
    public void delete(Long id) {
        // Deletar Cliente por ID.
        clienteRepository.deleteById(id);
    }

    private void salvarClienteNovo(Long id, ClienteModel cliente) {
        // Verificar se o cliente ja existe (pelo Cpf).
        Optional<ClienteModel> clienteExiste = clienteRepository.findById(id);
        if (clienteExiste.isPresent())
            return;
        insert(cliente);
        // Inserir Cliente, depois de testado se cpf existe.
        clienteRepository.save(cliente);
    }

}