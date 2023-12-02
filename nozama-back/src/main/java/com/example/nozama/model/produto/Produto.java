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

    @ManyToOne
    @JoinColumn(name = "pedido_id") // O nome da coluna de chave estrangeira na tabela Produto
    private Pedido pedido;

    public Produto(ProdutoRequestDTO data) {
        this.nome = data.nome();
        this.preco = data.preco();
    }
}