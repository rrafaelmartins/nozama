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

    @OneToMany //anotacao para indicar uma relação um para muitos
    private List<Produto> produtos;

    //@Transient -> ignoraria esse campo em operaçõs no banco dados, tornando-o um campo não persistido
    //acho que não se aplica nesse caso
    private EstadoPedido estado;

    //getters e setters são gerados automaticamente pelo Lombok
}

