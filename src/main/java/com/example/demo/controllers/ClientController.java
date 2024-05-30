package com.example.demo.controllers;

import com.example.demo.dto.request.ClientRequestDTO;
import com.example.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.response.ClientResponseDTO;
import java.util.List;

@RequestMapping("/clientes")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/newClient")
    public ClientResponseDTO createUser(@RequestBody ClientRequestDTO clientRequestDTO) {
        return clientService.createUser(clientRequestDTO);
    }

    @GetMapping("/getClients")
    public List<ClientResponseDTO> getAllUsers() {
        return clientService.getAllUsers();
    }

    @GetMapping("/getClient/{id}")
    public ClientResponseDTO getUserById(@PathVariable Long id) {
        return clientService.getUserById(id);
    }

    @PutMapping("/editClient/{id}")
    public ClientResponseDTO updateUser(@PathVariable Long id, @RequestBody ClientRequestDTO clientRequestDTO) {
        return clientService.updateUser(id, clientRequestDTO);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteUser(@PathVariable Long id) {
        clientService.deleteUser(id);
    }
}