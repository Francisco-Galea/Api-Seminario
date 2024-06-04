package com.example.demo.services;

import com.example.demo.dto.request.PedidoRequestDTO;
import com.example.demo.dto.response.PedidoResponseDTO;
import com.example.demo.mappers.PedidoMapper;
import com.example.demo.models.ItemPedidoModel;
import com.example.demo.models.PedidoModel;
import com.example.demo.repositories.IPedidoRepository;
import com.example.demo.repositories.IClienteRepository;
import com.example.demo.repositories.IItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


@Service
public class PedidoService {

    @Autowired
    private IPedidoRepository pedidoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private IClienteRepository clientRepository;

    @Autowired
    private IItemPedidoRepository itemPedidoRepository;

    public PedidoResponseDTO createPedido(PedidoRequestDTO dto) {
        PedidoModel pedido = pedidoMapper.toModel(dto);
        PedidoModel savedPedido = pedidoRepository.save(pedido);
        return pedidoMapper.toResponseDTO(savedPedido);
    }

    public PedidoResponseDTO getPedidoById(Long id) {
        PedidoModel pedido = pedidoRepository.findById(id).orElse(null);
        return pedidoMapper.toResponseDTO(pedido);
    }

    public List<PedidoResponseDTO> getAllPedidos() {
        List<PedidoModel> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(pedidoMapper::toResponseDTO).collect(Collectors.toList());
    }

    public PedidoResponseDTO updatePedido(Long id, PedidoRequestDTO dto) {
        PedidoModel existingPedido = pedidoRepository.findById(id).orElse(null);
        if (existingPedido != null) {
            existingPedido.setCliente(clientRepository.findById(dto.getClienteId()).orElse(null));
            List<ItemPedidoModel> items = dto.getItemIds().stream()
                    .map(itemPedidoRepository::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
            existingPedido.setItems(items);
            existingPedido.setFechaPedido(dto.getFechaPedido());

            PedidoModel updatedPedido = pedidoRepository.save(existingPedido);
            return pedidoMapper.toResponseDTO(updatedPedido);
        }
        return null;
    }

    public void deletePedido(Long id) {

        pedidoRepository.deleteById(id);
    }
}
