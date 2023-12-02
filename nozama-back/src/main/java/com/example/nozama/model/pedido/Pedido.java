package com.example.nozama.model.pedido;
import com.example.nozama.model.produto.Produto;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
@Table(name = "pedido")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<Produto> produtos;
    private Double valorTotal;

    public Pedido(PedidoRequestDTO data) {
        this.produtos = data.produtos();
        this.valorTotal = data.valorTotal();
    }
}