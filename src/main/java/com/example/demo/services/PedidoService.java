package com.example.demo.services;

import com.example.demo.dto.request.PedidoRequestDTO;
import com.example.demo.dto.response.PedidoResponseDTO;
import com.example.demo.mappers.PedidoMapper;
import com.example.demo.models.PedidoModel;
import com.example.demo.repositories.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private IPedidoRepository pedidoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    public PedidoResponseDTO createPedido(PedidoRequestDTO pedidoRequestDTO) {
        PedidoModel pedido = pedidoMapper.toModel(pedidoRequestDTO);
        pedido = pedidoRepository.save(pedido);
        return pedidoMapper.toDTO(pedido);
    }

    public List<PedidoResponseDTO> getAllPedidos() {
        return pedidoRepository.findAll().stream()
                .map(pedidoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PedidoResponseDTO getPedidoById(Long id) {
        Optional<PedidoModel> pedido = pedidoRepository.findById(id);
        return pedido.map(pedidoMapper::toDTO).orElse(null);
    }

    public PedidoResponseDTO updatePedido(Long id, PedidoRequestDTO pedidoRequestDTO) {
        Optional<PedidoModel> optionalPedido = pedidoRepository.findById(id);
        if (optionalPedido.isPresent()) {
            PedidoModel pedido = optionalPedido.get();
            pedido.setFecha(pedidoRequestDTO.getFecha());
            pedido = pedidoRepository.save(pedido);
            return pedidoMapper.toDTO(pedido);
        }
        return null;
    }

    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
