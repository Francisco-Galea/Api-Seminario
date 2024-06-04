package com.example.demo.repositories;

import com.example.demo.models.ItemPedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemPedidoRepository extends JpaRepository<ItemPedidoModel, Long> {
}
