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
        ItemPedidoModel itemPedido = new ItemPedidoModel();
        ProductoModel producto = productoRepository.findById(itemPedidoRequestDTO.getProductoId()).orElse(null);
        if (producto != null) {
            itemPedido.setProducto(producto);
            itemPedido.setCantidad(itemPedidoRequestDTO.getCantidad());
        }
        return itemPedido;
    }

    public ItemPedidoResponseDTO toDTO(ItemPedidoModel itemPedido) {
        ItemPedidoResponseDTO itemPedidoResponseDTO = new ItemPedidoResponseDTO();
        itemPedidoResponseDTO.setId(itemPedido.getId());
        itemPedidoResponseDTO.setProductoId(itemPedido.getProducto().getId());
        itemPedidoResponseDTO.setCantidad(itemPedido.getCantidad());
        return itemPedidoResponseDTO;
    }
}
