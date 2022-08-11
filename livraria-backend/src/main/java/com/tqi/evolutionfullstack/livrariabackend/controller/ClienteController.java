package com.tqi.evolutionfullstack.livrariabackend.controller;

import com.tqi.evolutionfullstack.livrariabackend.model.ClienteModel;
import com.tqi.evolutionfullstack.livrariabackend.repository.ClienteRepository;
import com.tqi.evolutionfullstack.livrariabackend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

//    private final ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;
//
//    public ClienteController(ClienteRepository clienteRepository) {
//        this.clienteRepository = clienteRepository;
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ClienteModel> cliente(@PathVariable("id") Long id) {
//        //ClienteModel cliente = clienteRepository.findClienteById(id);
//        //return ResponseEntity.ok(cliente);
//    }

//    @GetMapping("/salvar")
//    public ResponseEntity<Void> cliente() {
//        ClienteModel cliente = new ClienteModel();
//        cliente.setNome("Sergio");
//        cliente.setCpf("1234");
//        clienteRepository.save(cliente);
//        return ResponseEntity.ok().body(null);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findClientById(id));
    }

    @PostMapping
    public ResponseEntity<ClienteModel> insert(@RequestBody ClienteModel cliente) {
        clienteService.save(cliente);
        return ResponseEntity.ok(cliente);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ClienteModel> atualizar(@PathVariable Long id, @RequestBody ClienteModel cliente) {
//        clienteService.update(id, cliente);
//        return ResponseEntity.ok(cliente);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable Long id) {
//        clienteService.delete(id);
//        return ResponseEntity.ok().build();
//    }
}
