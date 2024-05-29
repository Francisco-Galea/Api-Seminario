package com.example.demo.services;

import com.example.demo.dto.request.UserRequestDTO;
import com.example.demo.dto.response.UserResponseDTO;
import com.example.demo.models.UserModel;
import com.example.demo.repositories.IUserRepository;
import com.example.demo.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        UserModel userModel = userMapper.toModel(userRequestDTO);
        userModel = userRepository.save(userModel);
        return userMapper.toDTO(userModel);
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDTO getUserById(Long id) {
        Optional<UserModel> userModel = userRepository.findById(id);
        return userModel.map(userMapper::toDTO).orElse(null);
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        Optional<UserModel> optionalUserModel = userRepository.findById(id);
        if (optionalUserModel.isPresent()) {
            UserModel userModel = optionalUserModel.get();
            userModel.setFirstName(userRequestDTO.getFirstName());
            userModel.setLastName(userRequestDTO.getLastName());
            userModel.setEmail(userRequestDTO.getEmail());
            userModel.setDni(userRequestDTO.getDni());
            userModel = userRepository.save(userModel);
            return userMapper.toDTO(userModel);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}