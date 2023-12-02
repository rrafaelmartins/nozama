package com.example.nozama.model.carrinho;
import java.util.List;


public class CarrinhoResponseDTO {
     public CarrinhoResponseDTO(Carrinho carrinho) {
        this(carrinho.getId(), carrinho.getIdCarrinhos(), carrinho.getValorTotal());
    }
}
