package com.example.nozama.model.pedido;
import java.util.List;

public record PedidoResponseDTO(Long id, List<Integer> idProdutos, double valorTotal) {

}
