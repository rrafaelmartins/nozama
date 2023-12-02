package com.example.nozama.model.carrinho;

import com.example.nozama.model.produto.Produto;

public class ProdutoCarrinho {
    public Produto produto;
    public int quantidade;

    public ProdutoCarrinho(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

     public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
