package com.example.demo.controllers;

import com.example.demo.dto.request.ClienteRequestDTO;
import com.example.demo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.response.ClienteResponseDTO;
import java.util.List;

@RequestMapping("/clientes")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/newCliente")
    public ClienteResponseDTO createUser(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        return clienteService.createUser(clienteRequestDTO);
    }

    @GetMapping("/getClientes")
    public List<ClienteResponseDTO> getAllUsers() {
        return clienteService.getAllUsers();
    }

    @GetMapping("/getCliente/{id}")
    public ClienteResponseDTO getUserById(@PathVariable Long id) {
        return clienteService.getUserById(id);
    }

    @PutMapping("/updateCliente/{id}")
    public ClienteResponseDTO updateUser(@PathVariable Long id, @RequestBody ClienteRequestDTO clienteRequestDTO) {
        return clienteService.updateUser(id, clienteRequestDTO);
    }

    @DeleteMapping("/deleteCliente/{id}")
    public void deleteUser(@PathVariable Long id) {
        clienteService.deleteUser(id);
    }
}