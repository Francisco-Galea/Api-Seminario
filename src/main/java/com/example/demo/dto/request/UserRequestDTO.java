package com.example.demo.dto.request;
import lombok.Data;

@Data
public class UserRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Long dni;
}