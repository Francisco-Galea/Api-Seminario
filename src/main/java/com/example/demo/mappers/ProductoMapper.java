package com.example.demo.mappers;

import com.example.demo.dto.request.ProductoRequestDTO;
import com.example.demo.dto.response.ProductoResponseDTO;
import com.example.demo.models.ProductoModel;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public ProductoModel toModel(ProductoRequestDTO productoRequestDTO) {
        ProductoModel producto = new ProductoModel();
        producto.setNombre(productoRequestDTO.getNombre());
        producto.setDescripcion(productoRequestDTO.getDescripcion());
        producto.setPrecio(productoRequestDTO.getPrecio());
        return producto;
    }

    public ProductoResponseDTO toDTO(ProductoModel producto) {
        ProductoResponseDTO productoResponseDTO = new ProductoResponseDTO();
        productoResponseDTO.setId(producto.getId());
        productoResponseDTO.setNombre(producto.getNombre());
        productoResponseDTO.setDescripcion(producto.getDescripcion());
        productoResponseDTO.setPrecio(producto.getPrecio());
        return productoResponseDTO;
    }
}