package com.example.demo.mappers;

import com.example.demo.dto.request.PedidoRequestDTO;
import com.example.demo.dto.response.PedidoResponseDTO;
import com.example.demo.models.PedidoModel;
import com.example.demo.models.ClientModel;
import com.example.demo.models.ItemPedidoModel;
import com.example.demo.repositories.IClientRepository;
import com.example.demo.repositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PedidoMapper {

    @Autowired
    private IClientRepository userRepository;

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private ItemPedidoMapper itemPedidoMapper;

    public PedidoModel toModel(PedidoRequestDTO pedidoRequestDTO) {
        PedidoModel pedido = new PedidoModel();
        ClientModel cliente = userRepository.findById(pedidoRequestDTO.getClienteId()).orElse(null);
        pedido.setCliente(cliente);
        pedido.setFecha(pedidoRequestDTO.getFecha());
        pedido.setItems(pedidoRequestDTO.getItems().stream().map(itemDTO -> {
            ItemPedidoModel itemPedido = itemPedidoMapper.toModel(itemDTO);
            itemPedido.setPedido(pedido);
            return itemPedido;
        }).collect(Collectors.toList()));
        return pedido;
    }

    public PedidoResponseDTO toDTO(PedidoModel pedido) {
        PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO();
        pedidoResponseDTO.setId(pedido.getId());
        pedidoResponseDTO.setClienteId(pedido.getCliente().getId());
        pedidoResponseDTO.setFecha(pedido.getFecha());
        pedidoResponseDTO.setItems(pedido.getItems().stream()
                .map(itemPedidoMapper::toDTO)
                .collect(Collectors.toList()));
        return pedidoResponseDTO;
    }
}
