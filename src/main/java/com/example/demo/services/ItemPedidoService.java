package com.example.demo.services;

import com.example.demo.dto.request.ItemPedidoRequestDTO;
import com.example.demo.dto.response.ItemPedidoResponseDTO;
import com.example.demo.mappers.ItemPedidoMapper;
import com.example.demo.models.ItemPedidoModel;
import com.example.demo.repositories.IItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoService {

    @Autowired
    private IItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ItemPedidoMapper itemPedidoMapper;

    public ItemPedidoResponseDTO createItemPedido(ItemPedidoRequestDTO itemPedidoRequestDTO) {
        ItemPedidoModel itemPedido = itemPedidoMapper.toModel(itemPedidoRequestDTO);
        itemPedido = itemPedidoRepository.save(itemPedido);
        return itemPedidoMapper.toDTO(itemPedido);
    }

    // Otros métodos CRUD si es necesario
}
