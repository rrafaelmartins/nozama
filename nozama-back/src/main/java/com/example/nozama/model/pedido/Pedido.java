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

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToMany(mappedBy = "pedido", cascade = CascadeType.MERGE, orphanRemoval = true)
        private List<Produto> produtos;

        @ManyToOne(cascade = CascadeType.MERGE)
        @JoinColumn(name = "user_id")
        private User user;

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
