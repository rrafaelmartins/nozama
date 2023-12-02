package com.example.nozama.model.pedido;

import java.util.List;

public record PedidoRequestDTO(List<Integer> idProdutos, double valorTotal){

}
