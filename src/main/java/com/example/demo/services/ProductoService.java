package com.example.demo.services;

import com.example.demo.dto.request.ProductoRequestDTO;
import com.example.demo.dto.response.ProductoResponseDTO;
import com.example.demo.mappers.ProductoMapper;
import com.example.demo.models.ProductoModel;
import com.example.demo.repositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    public ProductoResponseDTO createProducto(ProductoRequestDTO productoRequestDTO) {
        ProductoModel producto = productoMapper.toModel(productoRequestDTO);
        producto = productoRepository.save(producto);
        return productoMapper.toDTO(producto);
    }

    public List<ProductoResponseDTO> getAllProductos() {
        return productoRepository.findAll().stream()
                .map(productoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductoResponseDTO getProductoById(Long id) {
        Optional<ProductoModel> producto = productoRepository.findById(id);
        return producto.map(productoMapper::toDTO).orElse(null);
    }

    public ProductoResponseDTO updateProducto(Long id, ProductoRequestDTO productoRequestDTO) {
        Optional<ProductoModel> optionalProducto = productoRepository.findById(id);
        if (optionalProducto.isPresent()) {
            ProductoModel producto = optionalProducto.get();
            producto.setNombre(productoRequestDTO.getNombre());
            producto.setDescripcion(productoRequestDTO.getDescripcion());
            producto.setPrecio(productoRequestDTO.getPrecio());
            producto = productoRepository.save(producto);
            return productoMapper.toDTO(producto);
        }
        return null;
    }

    public void deleteProducto(Long id) {

        productoRepository.deleteById(id);
    }
}