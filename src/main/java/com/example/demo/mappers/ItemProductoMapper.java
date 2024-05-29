package com.example.demo.mappers;

import com.example.demo.dto.request.ItemProductoRequestDTO;
import com.example.demo.dto.response.ItemProductoResponseDTO;
import com.example.demo.models.ItemProductoModel;
import com.example.demo.repositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemProductoMapper {

    @Autowired
    private IProductoRepository productoRepository;

    public ItemProductoModel toModel(ItemProductoRequestDTO itemProductoRequestDTO) {
        ItemProductoModel itemProducto = new ItemProductoModel();
        itemProducto.setProducto(productoRepository.findById(itemProductoRequestDTO.getProductoId()).orElse(null));
        itemProducto.setCantidad(itemProductoRequestDTO.getCantidad());
        return itemProducto;
    }

    public ItemProductoResponseDTO toDTO(ItemProductoModel itemProducto) {
        ItemProductoResponseDTO itemProductoResponseDTO = new ItemProductoResponseDTO();
        itemProductoResponseDTO.setId(itemProducto.getId());
        itemProductoResponseDTO.setProductoId(itemProducto.getProducto().getId());
        itemProductoResponseDTO.setCantidad(itemProducto.getCantidad());
        return itemProductoResponseDTO;
    }
}