package com.example.demo.dto.response;

import lombok.Data;
@Data
public class ProductoResponseDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
}