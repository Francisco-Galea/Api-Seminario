package com.example.demo.dto.response;
import lombok.Data;

@Data
public class ClienteResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long dni;
}