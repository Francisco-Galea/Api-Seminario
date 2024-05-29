package com.example.demo.controllers;
import com.example.demo.dto.request.UserRequestDTO;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.response.UserResponseDTO;
import java.util.List;



@RequestMapping("/clientes")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/newClient")
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.createUser(userRequestDTO);
    }

    @GetMapping("/getClients")
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getClient/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/editClient/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        return userService.updateUser(id, userRequestDTO);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}