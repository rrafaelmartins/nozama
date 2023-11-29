package com.example.nozama.model.pedido;
import com.example.nozama.model.produto.Produto;
import com.example.nozama.model.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany //Anotação para indicar uma relação um para muitos
    private List<Produto> produtos;

    @ManyToOne
    @JoinColumn(name = "user_id") // Chave estrangeira na tabela Pedido
    private User user;

    //@Transient -> Ignoraria esse campo em operações no banco dados, tornando-o um campo não persistido
    //Acho que não se aplica nesse caso
    private EstadoPedido estado;

    //Getters e Setters são gerados automaticamente pelo Lombok
}

