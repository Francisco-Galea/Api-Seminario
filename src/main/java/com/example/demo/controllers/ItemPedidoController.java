package com.example.demo.controllers;

import com.example.demo.dto.request.ItemPedidoRequestDTO;
import com.example.demo.dto.response.ItemPedidoResponseDTO;
import com.example.demo.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/items")
@RestController
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping("/newItem")
    public ItemPedidoResponseDTO createItemPedido(@RequestBody ItemPedidoRequestDTO itemPedidoRequestDTO) {
        return itemPedidoService.createItemPedido(itemPedidoRequestDTO);
    }


}
