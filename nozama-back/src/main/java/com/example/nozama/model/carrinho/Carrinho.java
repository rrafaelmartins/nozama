package com.example.nozama.model.carrinho;
import java.util.ArrayList;
import java.util.List;

import com.example.nozama.model.carrinho.CarrinhoRequestDTO;
import com.example.nozama.model.user.User;

import jakarta.persistence.*;
import lombok.*;
@Table(name = "carrinho")
@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="carrinho_id")
    private Long id;

    //@JoinColumn(name = "carrinho_id", insertable = false, updatable = false)
    @OneToMany
    private List<ProdutoCarrinho> produtos;

    public Carrinho(CarrinhoRequestDTO data) {
        this.produtos = data.produtos();
    }
    public Carrinho() {
        this.produtos = new ArrayList<>();
    }
    public void AtualizarProduto(ProdutoCarrinho produtoCarrinho) {
        this.produtos.add(produtoCarrinho);
    }
}
