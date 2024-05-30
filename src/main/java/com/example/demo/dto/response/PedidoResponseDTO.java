package com.example.demo.dto.response;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class PedidoResponseDTO {
    private Long id;
    private Long clienteId;
    private Date fecha;
    private List<ItemPedidoResponseDTO> items;
}