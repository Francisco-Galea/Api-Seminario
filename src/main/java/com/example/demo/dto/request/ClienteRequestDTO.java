package com.example.demo.dto.request;

import lombok.Data;

@Data
public class ClienteRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Long dni;
}