package com.example.nozama.model.carrinho;
import java.util.List;

import com.example.nozama.model.carrinho.CarrinhoRequestDTO;

import jakarta.persistence.*;
import lombok.*;
@Table(name = "pedido")
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

    private List<Integer> idCarrinhos;
    private Double valorTotal;

    public Carrinho(CarrinhoRequestDTO data) {
        this.idCarrinhos = data.idCarrinhos();
        this.valorTotal = data.valorTotal();
    }

}
