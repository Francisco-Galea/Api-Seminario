package com.example.demo.mappers;

import com.example.demo.dto.request.PedidoRequestDTO;
import com.example.demo.dto.response.PedidoResponseDTO;
import com.example.demo.models.PedidoModel;
import com.example.demo.models.ClientModel;
import com.example.demo.models.ItemPedidoModel;
import com.example.demo.repositories.IClientRepository;
import com.example.demo.repositories.IItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoMapper {

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IItemPedidoRepository itemPedidoRepository;

    public PedidoModel toModel(PedidoRequestDTO dto) {
        PedidoModel pedido = new PedidoModel();
        ClientModel client = clientRepository.findById(dto.getClienteId()).orElse(null);
        List<ItemPedidoModel> items = dto.getItemIds().stream()
                .map(id -> itemPedidoRepository.findById(id).orElse(null))
                .collect(Collectors.toList());

        pedido.setCliente(client);
        pedido.setItems(items);
        pedido.setFechaPedido(dto.getFechaPedido());
        return pedido;
    }

    public PedidoResponseDTO toResponseDTO(PedidoModel model) {
        PedidoResponseDTO dto = new PedidoResponseDTO();
        dto.setId(model.getId());
        dto.setCliente(model.getCliente());
        dto.setItems(model.getItems());
        dto.setFechaPedido(model.getFechaPedido());
        return dto;
    }
}
