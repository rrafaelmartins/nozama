package com.example.nozama.model.carrinho;
import java.util.List;


public record CarrinhoResponseDTO(Long id, List<ProdutoCarrinho> produtos) {
     public CarrinhoResponseDTO(Carrinho carrinho) {
        this(carrinho.getId(), carrinho.getProdutos());
    }
}
