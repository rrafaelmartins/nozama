package com.example.nozama.model.carrinho;
import java.util.List;

import com.example.nozama.model.carrinho.CarrinhoRequestDTO;

import jakarta.persistence.*;
import lombok.*;
@Table(name = "carrinho")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@JoinColumn(name = "carrinho_id", insertable = false, updatable = false)
    @OneToMany
    private List<ProdutoCarrinho> produtos;

    public Carrinho(CarrinhoRequestDTO data) {
        this.produtos = data.produtos();
    }

}
