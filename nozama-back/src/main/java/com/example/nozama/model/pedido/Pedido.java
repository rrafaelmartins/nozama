package com.example.nozama.model.pedido;
import com.example.nozama.model.produto.Produto;
import com.example.nozama.model.user.User;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.example.nozama.model.produto.Produto;
import com.example.nozama.model.user.User;

import jakarta.persistence.*;
import lombok.*;
@Table(name = "pedido")
@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

        @JoinColumn(name = "pedido_id", insertable = false, updatable = false)
        @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true)
        private List<Produto> produtos;

        @ManyToOne()
        @JoinColumn(name = "user_id", updatable = false)
        @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
        private User user;

        @JsonIgnore
        @Transient // Ignora na deserialização e não persiste no banco de dados.
        private Long userId;

        private String estadoNome; // Armazena o nome do estado como String

    @Transient
    private EstadoPedido estado; // Campo transiente, não persistido

    public Pedido() {
        this.estado = new PedidoNovo(this);
        this.estadoNome = this.estado.toString(); // Definir o nome do estado inicial aqui
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        this.estadoNome = estado.toString(); // Atualizar o nome do estado
    }

    public void proximoEstado() {
        estado.proximoEstado();
        this.estadoNome = estado.toString();
    }

    public void estadoAnterior() {
        estado.estadoAnterior();
        this.estadoNome = estado.toString();
    }
    
    //Getters e Setters são gerados automaticamente pelo Lombok
}
