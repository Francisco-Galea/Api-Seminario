package com.example.demo.mappers;

import com.example.demo.dto.request.PedidoRequestDTO;
import com.example.demo.dto.response.PedidoResponseDTO;
import com.example.demo.models.PedidoModel;
import com.example.demo.models.ClienteModel;
import com.example.demo.models.ItemPedidoModel;
import com.example.demo.repositories.IClienteRepository;
import com.example.demo.repositories.IItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PedidoMapper {

    @Autowired
    private IClienteRepository clientRepository;

    @Autowired
    private IItemPedidoRepository itemPedidoRepository;

    public PedidoModel toModel(PedidoRequestDTO dto) {
        PedidoModel pedidoModel = new PedidoModel();
        ClienteModel client = clientRepository.findById(dto.getClienteId()).orElse(null);
        List<ItemPedidoModel> items = dto.getItemIds().stream()
                .map(id -> itemPedidoRepository.findById(id).orElse(null))
                .collect(Collectors.toList());
        pedidoModel.setCliente(client);
        pedidoModel.setItems(items);
        pedidoModel.setFechaPedido(dto.getFechaPedido());
        return pedidoModel;
    }

    public PedidoResponseDTO toResponseDTO(PedidoModel model) {
        PedidoResponseDTO PedidoResponseDTO = new PedidoResponseDTO();
        PedidoResponseDTO.setId(model.getId());
        PedidoResponseDTO.setCliente(model.getCliente());
        PedidoResponseDTO.setItems(model.getItems());
        PedidoResponseDTO.setFechaPedido(model.getFechaPedido());
        return PedidoResponseDTO;
    }
}
