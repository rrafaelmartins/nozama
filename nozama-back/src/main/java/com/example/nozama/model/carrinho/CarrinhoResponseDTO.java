package com.example.nozama.model.carrinho;
import java.util.List;


public record CarrinhoResponseDTO(Long id, List<Integer> idCarrinhos, Double valorTotal) {
     public CarrinhoResponseDTO(Carrinho carrinho) {
        this(carrinho.getId(), carrinho.getIdCarrinhos(), carrinho.getValorTotal());
    }
}
