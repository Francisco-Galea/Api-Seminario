package com.example.demo.controllers;

import com.example.demo.dto.request.ItemPedidoRequestDTO;
import com.example.demo.dto.response.ItemPedidoResponseDTO;
import com.example.demo.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/itemPedido")
@RestController
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping("/addItemPedido")
    public ItemPedidoResponseDTO createItemPedido(@RequestBody ItemPedidoRequestDTO itemPedidoRequestDTO) {
        return itemPedidoService.createItemPedido(itemPedidoRequestDTO);
    }



    @GetMapping("/getItemsPedido")
    public List<ItemPedidoResponseDTO> getAllItemsPedido() {
        return itemPedidoService.getAllItemsPedido();
    }

    @GetMapping("/getItemPedido/{id}")
    public ItemPedidoResponseDTO getItemPedidoById(@PathVariable Long id) {
        return itemPedidoService.getItemPedidoById(id);
    }

    @PutMapping("/updateItemPedido/{id}")
    public ItemPedidoResponseDTO updateItemPedido(@PathVariable Long id, @RequestBody ItemPedidoRequestDTO itemPedidoRequestDTO) {
        return itemPedidoService.updateItemPedido(id, itemPedidoRequestDTO);
    }

    @DeleteMapping("/deleteItemPedido/{id}")
    public void deleteItemPedido(@PathVariable Long id) {
        itemPedidoService.deleteItemPedido(id);
    }
}
