package com.example.demo.services;

import com.example.demo.dto.request.ClientRequestDTO;
import com.example.demo.dto.response.ClientResponseDTO;
import com.example.demo.models.ClientModel;
import com.example.demo.repositories.IClientRepository;
import com.example.demo.mappers.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private IClientRepository userRepository;

    @Autowired
    private ClientMapper clientMapper;

    public ClientResponseDTO createUser(ClientRequestDTO clientRequestDTO) {
        ClientModel clientModel = clientMapper.toModel(clientRequestDTO);
        clientModel = userRepository.save(clientModel);
        return clientMapper.toDTO(clientModel);
    }

    public List<ClientResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClientResponseDTO getUserById(Long id) {
        Optional<ClientModel> userModel = userRepository.findById(id);
        return userModel.map(clientMapper::toDTO).orElse(null);
    }

    public ClientResponseDTO updateUser(Long id, ClientRequestDTO clientRequestDTO) {
        Optional<ClientModel> optionalUserModel = userRepository.findById(id);
        if (optionalUserModel.isPresent()) {
            ClientModel clientModel = optionalUserModel.get();
            clientModel.setFirstName(clientRequestDTO.getFirstName());
            clientModel.setLastName(clientRequestDTO.getLastName());
            clientModel.setEmail(clientRequestDTO.getEmail());
            clientModel.setDni(clientRequestDTO.getDni());
            clientModel = userRepository.save(clientModel);
            return clientMapper.toDTO(clientModel);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}