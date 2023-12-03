package com.example.nozama.model.carrinho;

import com.example.nozama.model.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoCarrinhoRepository extends JpaRepository<ProdutoCarrinho, Long> {
}