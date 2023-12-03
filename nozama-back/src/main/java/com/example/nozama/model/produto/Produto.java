package com.example.nozama.model.produto;
import com.example.nozama.model.pedido.Pedido;
import jakarta.persistence.*;
import lombok.*;
@Table(name = "produto")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double preco;


    public Produto(ProdutoRequestDTO data) {
        this.nome = data.nome();
        this.preco = data.preco();
    }
}