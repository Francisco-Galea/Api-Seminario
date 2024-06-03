package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pedidos")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClientModel cliente;

    @OneToMany
    @JoinColumn(name = "pedido")
    private List<ItemPedidoModel> items;

    @Column(name = "fecha_pedido")
    private Date fechaPedido;
}
