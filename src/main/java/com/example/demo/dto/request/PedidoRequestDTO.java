package com.example.demo.dto.request;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class PedidoRequestDTO {
    private Long clienteId;
    private List<Long> itemIds;
    private Date fechaPedido;
}
