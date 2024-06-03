package com.example.demo.dto.response;

import com.example.demo.models.ProductoModel;
import lombok.Data;

@Data
public class ItemPedidoResponseDTO {
    private Long id;
    private ProductoModel producto;
    private int cantidad;
}