package com.example.demo.dto.response;

import com.example.demo.models.ItemPedidoModel;
import com.example.demo.models.ClienteModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PedidoResponseDTO {
    private Long id;
    private ClienteModel cliente;
    private List<ItemPedidoModel> items;
    private Date fechaPedido;
}
