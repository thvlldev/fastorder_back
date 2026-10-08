package com.sistema.api.model.pedido;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, UUID>{
    
}
