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
    private IClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public ClienteResponseDTO createCliente(ClienteRequestDTO clienteRequestDTO) {
        ClienteModel clienteModel = clienteMapper.toModel(clienteRequestDTO);
        clienteModel = clienteRepository.save(clienteModel);
        return clienteMapper.toDTO(clienteModel);
    }

    public List<ClienteResponseDTO> getAllCliente() {
        return clienteRepository.findAll().stream()
                .map(clienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteResponseDTO getClienteById(Long id) {
        Optional<ClienteModel> userModel = clienteRepository.findById(id);
        return userModel.map(clienteMapper::toDTO).orElse(null);
    }

    public ClienteResponseDTO updateUser(Long id, ClienteRequestDTO clienteRequestDTO) {
        Optional<ClienteModel> optionalUserModel = clienteRepository.findById(id);
        if (optionalUserModel.isPresent()) {
            ClienteModel clienteModel = optionalUserModel.get();
            clienteModel.setFirstName(clienteRequestDTO.getFirstName());
            clienteModel.setLastName(clienteRequestDTO.getLastName());
            clienteModel.setEmail(clienteRequestDTO.getEmail());
            clienteModel.setDni(clienteRequestDTO.getDni());
            clienteModel = clienteRepository.save(clienteModel);
            return clienteMapper.toDTO(clienteModel);
        }
        return null;
    }

    public void deleteCliente(Long id) {

        clienteRepository.deleteById(id);
    }
}