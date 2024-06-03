package com.example.demo.mappers;

import com.example.demo.dto.request.ItemPedidoRequestDTO;
import com.example.demo.dto.response.ItemPedidoResponseDTO;
import com.example.demo.models.ItemPedidoModel;
import com.example.demo.models.ProductoModel;
import com.example.demo.repositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemPedidoMapper {

    @Autowired
    private IProductoRepository productoRepository;

    public ItemPedidoModel toModel(ItemPedidoRequestDTO itemPedidoRequestDTO) {
        ItemPedidoModel itemPedidoModel = new ItemPedidoModel();
        ProductoModel producto = productoRepository.findById(itemPedidoRequestDTO.getProductoId()).orElse(null);
        if (producto != null) {
            itemPedidoModel.setProducto(producto);
            itemPedidoModel.setCantidad(itemPedidoRequestDTO.getCantidad());
        }
        return itemPedidoModel;
    }

    public ItemPedidoResponseDTO toDTO(ItemPedidoModel itemPedido) {
        ItemPedidoResponseDTO itemPedidoResponseDTO = new ItemPedidoResponseDTO();
        itemPedidoResponseDTO.setId(itemPedido.getId());
        itemPedidoResponseDTO.setProducto(itemPedido.getProducto());
        itemPedidoResponseDTO.setCantidad(itemPedido.getCantidad());
        return itemPedidoResponseDTO;
    }
}
