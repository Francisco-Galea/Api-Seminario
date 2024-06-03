package com.example.demo.controllers;

import com.example.demo.dto.request.ProductoRequestDTO;
import com.example.demo.dto.response.ProductoResponseDTO;
import com.example.demo.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/productos")
@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/newProducto")
    public ProductoResponseDTO createProducto(@RequestBody ProductoRequestDTO productoRequestDTO) {
        return productoService.createProducto(productoRequestDTO);
    }

    @GetMapping("/getProductos")
    public List<ProductoResponseDTO> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/getProducto/{id}")
    public ProductoResponseDTO getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

    @PutMapping("/updateProducto/{id}")
    public ProductoResponseDTO updateProducto(@PathVariable Long id, @RequestBody ProductoRequestDTO productoRequestDTO) {
        return productoService.updateProducto(id, productoRequestDTO);
    }

    @DeleteMapping("/deleteProducto/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
    }
}