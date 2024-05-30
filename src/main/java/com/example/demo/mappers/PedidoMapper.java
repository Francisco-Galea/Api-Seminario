package com.example.demo.mappers;

import com.example.demo.dto.request.PedidoRequestDTO;
import com.example.demo.dto.response.PedidoResponseDTO;
import com.example.demo.models.PedidoModel;
import com.example.demo.models.ClientModel;
import com.example.demo.models.ItemProductoModel;
import com.example.demo.repositories.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class PedidoMapper {

    @Autowired
    private IClientRepository userRepository;

    @Autowired
    private ItemProductoMapper itemProductoMapper;

    public PedidoModel toModel(PedidoRequestDTO pedidoRequestDTO) {
        PedidoModel pedido = new PedidoModel();
        ClientModel cliente = userRepository.findById(pedidoRequestDTO.getClienteId()).orElse(null);
        pedido.setCliente(cliente);
        pedido.setFecha(pedidoRequestDTO.getFecha());
        pedido.setItems(pedidoRequestDTO.getItems().stream().map(itemDTO -> {
            ItemProductoModel itemProducto = new ItemProductoModel();
            itemProducto.setPedido(pedido);
            return itemProducto;
        }).collect(Collectors.toList()));
        return pedido;
    }

    public PedidoResponseDTO toDTO(PedidoModel pedido) {
        PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO();
        pedidoResponseDTO.setId(pedido.getId());
        pedidoResponseDTO.setClienteId(pedido.getCliente().getId());
        pedidoResponseDTO.setFecha(pedido.getFecha());
        pedidoResponseDTO.setItems(pedido.getItems().stream()
                .map(itemProductoMapper::toDTO)
                .collect(Collectors.toList()));
        return pedidoResponseDTO;
    }
}