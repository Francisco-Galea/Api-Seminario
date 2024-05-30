package com.example.demo.mappers;

import com.example.demo.dto.request.ClientRequestDTO;
import com.example.demo.dto.response.ClientResponseDTO;
import com.example.demo.models.ClientModel;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientModel toModel(ClientRequestDTO clientRequestDTO) {
        ClientModel clientModel = new ClientModel();
        clientModel.setFirstName(clientRequestDTO.getFirstName());
        clientModel.setLastName(clientRequestDTO.getLastName());
        clientModel.setEmail(clientRequestDTO.getEmail());
        clientModel.setDni(clientRequestDTO.getDni());
        return clientModel;
    }

    public ClientResponseDTO toDTO(ClientModel clientModel) {
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO();
        clientResponseDTO.setId(clientModel.getId());
        clientResponseDTO.setFirstName(clientModel.getFirstName());
        clientResponseDTO.setLastName(clientModel.getLastName());
        clientResponseDTO.setEmail(clientModel.getEmail());
        clientResponseDTO.setDni(clientModel.getDni());
        return clientResponseDTO;
    }
}