package com.example.nozama.model.pedido;
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

    private List<Integer> idProdutos;
    private Double valorTotal;

    public Pedido(PedidoRequestDTO data) {
        this.idProdutos = data.idProdutos();
        this.valorTotal = data.valorTotal();
    }
}
