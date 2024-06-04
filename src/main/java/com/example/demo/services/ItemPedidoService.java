package com.example.demo.services;

import com.example.demo.dto.request.ItemPedidoRequestDTO;
import com.example.demo.dto.response.ItemPedidoResponseDTO;
import com.example.demo.mappers.ItemPedidoMapper;
import com.example.demo.models.ItemPedidoModel;
import com.example.demo.models.ProductoModel;
import com.example.demo.repositories.IItemPedidoRepository;
import com.example.demo.repositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemPedidoService {

    @Autowired
    private IItemPedidoRepository itemPedidoRepository;
    @Autowired
    private ItemPedidoMapper itemPedidoMapper;
    @Autowired
    private IProductoRepository productoRepository;

    public ItemPedidoResponseDTO updateItemPedido(Long id, ItemPedidoRequestDTO itemPedidoRequestDTO) {
        Optional<ItemPedidoModel> optionalItemPedido = itemPedidoRepository.findById(id);
        if (optionalItemPedido.isPresent()) {
            ItemPedidoModel itemPedido = optionalItemPedido.get();
            Optional<ProductoModel> optionalProducto = productoRepository.findById(itemPedidoRequestDTO.getProductoId());
            if (optionalProducto.isPresent()) {
                ProductoModel nuevoProducto = optionalProducto.get();
                itemPedido.setProducto(nuevoProducto);
            }
            else {
                return null;
            }
            itemPedido.setCantidad(itemPedidoRequestDTO.getCantidad());
            itemPedido = itemPedidoRepository.save(itemPedido);
            return itemPedidoMapper.toDTO(itemPedido);
        }
        return null;
    }

    public ItemPedidoResponseDTO createItemPedido(ItemPedidoRequestDTO itemPedidoRequestDTO) {
        ItemPedidoModel itemPedido = itemPedidoMapper.toModel(itemPedidoRequestDTO);
        itemPedido = itemPedidoRepository.save(itemPedido);
        return itemPedidoMapper.toDTO(itemPedido);
    }

    public List<ItemPedidoResponseDTO> getAllItemsPedido() {
        return itemPedidoRepository.findAll().stream()
                .map(itemPedidoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ItemPedidoResponseDTO getItemPedidoById(Long id) {
        Optional<ItemPedidoModel> itemPedido = itemPedidoRepository.findById(id);
        return itemPedido.map(itemPedidoMapper::toDTO).orElse(null);
    }

    public void deleteItemPedido(Long id) {

        itemPedidoRepository.deleteById(id);
    }
}
