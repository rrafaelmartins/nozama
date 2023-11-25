package com.example.nozama.model.produto;
public record ProdutoResponseDTO(Long id, String nome, Double preco) {
    public ProdutoResponseDTO(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getPreco());
    }
}
