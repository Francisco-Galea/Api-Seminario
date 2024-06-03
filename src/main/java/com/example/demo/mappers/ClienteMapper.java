package com.example.demo.mappers;

import com.example.demo.dto.request.ClienteRequestDTO;
import com.example.demo.dto.response.ClienteResponseDTO;
import com.example.demo.models.ClienteModel;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteModel toModel(ClienteRequestDTO clienteRequestDTO) {
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setFirstName(clienteRequestDTO.getFirstName());
        clienteModel.setLastName(clienteRequestDTO.getLastName());
        clienteModel.setEmail(clienteRequestDTO.getEmail());
        clienteModel.setDni(clienteRequestDTO.getDni());
        return clienteModel;
    }

    public ClienteResponseDTO toDTO(ClienteModel clienteModel) {
        ClienteResponseDTO clientResponseDTO = new ClienteResponseDTO();
        clientResponseDTO.setId(clienteModel.getId());
        clientResponseDTO.setFirstName(clienteModel.getFirstName());
        clientResponseDTO.setLastName(clienteModel.getLastName());
        clientResponseDTO.setEmail(clienteModel.getEmail());
        clientResponseDTO.setDni(clienteModel.getDni());
        return clientResponseDTO;
    }
}