package com.example.demo.repositories;

import com.example.demo.models.ItemProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemProductoRepository extends JpaRepository<ItemProductoModel, Long> {
}