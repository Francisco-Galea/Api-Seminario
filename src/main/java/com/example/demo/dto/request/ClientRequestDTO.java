package com.example.demo.dto.request;

import lombok.Data;

@Data
public class ClientRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Long dni;
}