package com.example.demo.repositories;

import com.example.demo.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<ClienteModel, Long> {
}