package com.example.demo.controllers;

import com.example.demo.dto.request.PedidoRequestDTO;
import com.example.demo.dto.response.PedidoResponseDTO;
import com.example.demo.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/pedidos")
@RestController
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/newOrder")
    public PedidoResponseDTO createPedido(@RequestBody PedidoRequestDTO pedidoRequestDTO) {
        return pedidoService.createPedido(pedidoRequestDTO);
    }

    @GetMapping("/getOrders")
    public List<PedidoResponseDTO> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @GetMapping("/getOrder/{id}")
    public PedidoResponseDTO getPedidoById(@PathVariable Long id) {
        return pedidoService.getPedidoById(id);
    }

    @PutMapping("/editOrder/{id}")
    public PedidoResponseDTO updatePedido(@PathVariable Long id, @RequestBody PedidoRequestDTO pedidoRequestDTO) {
        return pedidoService.updatePedido(id, pedidoRequestDTO);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public void deletePedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
    }
}