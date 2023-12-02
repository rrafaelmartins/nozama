package com.example.nozama.model.pedido;
import java.util.List;
import com.example.nozama.model.produto.Produto;

public record PedidoResponseDTO(Long id, List<Produto> produtos, double valorTotal) {
    public PedidoResponseDTO(Pedido pedido) {
        this(pedido.getId(), pedido.getProdutos(), pedido.getValorTotal());
    }
}
