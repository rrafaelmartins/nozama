package com.example.nozama.model.carrinho;
import java.util.List;

public record CarrinhoRequestDTO(List<Integer> idCarrinhos, double valorTotal) {
    
}
