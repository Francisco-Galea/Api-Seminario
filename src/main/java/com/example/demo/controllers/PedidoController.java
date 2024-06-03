package com.example.demo.controllers;

import com.example.demo.dto.request.PedidoRequestDTO;
import com.example.demo.dto.response.PedidoResponseDTO;
import com.example.demo.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public PedidoResponseDTO createPedido(@RequestBody PedidoRequestDTO dto) {
        return pedidoService.createPedido(dto);
    }

    @GetMapping("/{id}")
    public PedidoResponseDTO getPedidoById(@PathVariable Long id) {
        return pedidoService.getPedidoById(id);
    }

    @GetMapping
    public List<PedidoResponseDTO> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @PutMapping("/{id}")
    public PedidoResponseDTO updatePedido(@PathVariable Long id, @RequestBody PedidoRequestDTO dto) {
        return pedidoService.updatePedido(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
    }
}
