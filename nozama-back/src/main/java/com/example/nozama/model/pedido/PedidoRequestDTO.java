package com.example.nozama.model.pedido;

import com.example.nozama.model.produto.Produto;
import com.example.nozama.model.produto.ProdutoResponseDTO;
import com.example.nozama.model.user.User;

import java.util.List;

public record PedidoRequestDTO(List<Produto> produtos, Long userId, String estadoNome){

}
