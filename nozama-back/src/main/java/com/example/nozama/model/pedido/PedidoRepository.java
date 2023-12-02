package com.example.nozama.model.pedido;

import com.example.nozama.model.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}