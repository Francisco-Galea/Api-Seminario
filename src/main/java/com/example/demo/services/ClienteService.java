package com.example.demo.services;

import com.example.demo.dto.request.ClienteRequestDTO;
import com.example.demo.dto.response.ClienteResponseDTO;
import com.example.demo.models.ClienteModel;
import com.example.demo.repositories.IClienteRepository;
import com.example.demo.mappers.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository userRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public ClienteResponseDTO createUser(ClienteRequestDTO clienteRequestDTO) {
        ClienteModel clienteModel = clienteMapper.toModel(clienteRequestDTO);
        clienteModel = userRepository.save(clienteModel);
        return clienteMapper.toDTO(clienteModel);
    }

    public List<ClienteResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(clienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteResponseDTO getUserById(Long id) {
        Optional<ClienteModel> userModel = userRepository.findById(id);
        return userModel.map(clienteMapper::toDTO).orElse(null);
    }

    public ClienteResponseDTO updateUser(Long id, ClienteRequestDTO clienteRequestDTO) {
        Optional<ClienteModel> optionalUserModel = userRepository.findById(id);
        if (optionalUserModel.isPresent()) {
            ClienteModel clienteModel = optionalUserModel.get();
            clienteModel.setFirstName(clienteRequestDTO.getFirstName());
            clienteModel.setLastName(clienteRequestDTO.getLastName());
            clienteModel.setEmail(clienteRequestDTO.getEmail());
            clienteModel.setDni(clienteRequestDTO.getDni());
            clienteModel = userRepository.save(clienteModel);
            return clienteMapper.toDTO(clienteModel);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}