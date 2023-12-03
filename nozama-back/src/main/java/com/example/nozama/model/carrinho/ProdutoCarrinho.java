package com.example.nozama.model.carrinho;

import com.example.nozama.model.produto.Produto;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "produtocarrinho")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProdutoCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    public Produto produto;
    public int quantidade;

    public ProdutoCarrinho(Produto produto, int i) {
        this.produto = produto;
        this.quantidade = i;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

     public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
