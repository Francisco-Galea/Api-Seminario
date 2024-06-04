package com.example.demo.repositories;

import com.example.demo.models.ItemPedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemPedidoRepository extends JpaRepository<ItemPedidoModel, Long> {
}
