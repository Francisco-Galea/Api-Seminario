package com.example.demo.mappers;

import com.example.demo.dto.request.UserRequestDTO;
import com.example.demo.dto.response.UserResponseDTO;
import com.example.demo.models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserModel toModel(UserRequestDTO userRequestDTO) {
        UserModel userModel = new UserModel();
        userModel.setFirstName(userRequestDTO.getFirstName());
        userModel.setLastName(userRequestDTO.getLastName());
        userModel.setEmail(userRequestDTO.getEmail());
        userModel.setDni(userRequestDTO.getDni());
        return userModel;
    }

    public UserResponseDTO toDTO(UserModel userModel) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(userModel.getId());
        userResponseDTO.setFirstName(userModel.getFirstName());
        userResponseDTO.setLastName(userModel.getLastName());
        userResponseDTO.setEmail(userModel.getEmail());
        userResponseDTO.setDni(userModel.getDni());
        return userResponseDTO;
    }
}