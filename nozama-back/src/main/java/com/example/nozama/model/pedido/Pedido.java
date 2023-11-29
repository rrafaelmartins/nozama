package com.example.nozama.model.pedido;
import com.example.nozama.model.produto.Produto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany //AnotaÇÃO para indicar uma relação um para muitos
    private List<Produto> produtos;

    //@Transient -> Ignoraria esse campo em operações no banco dados, tornando-o um campo não persistido
    //Acho que não se aplica nesse caso
    private EstadoPedido estado;

    //Getters e Setters são gerados automaticamente pelo Lombok
}

