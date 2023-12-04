package com.example.nozama.model.pedido;

import com.example.nozama.model.carrinho.ProdutoCarrinho;

import java.util.List;

public record PedidoRequestDTO(List<ProdutoCarrinho> produtos, Long userId, String estadoNome){

}
