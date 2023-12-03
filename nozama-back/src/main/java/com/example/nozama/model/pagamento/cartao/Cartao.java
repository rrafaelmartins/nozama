package com.example.nozama.model.pagamento.cartao;
import com.example.nozama.model.user.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.*;
@Table(name = "cartao")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cartao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titular;
    private String numero;
    private String vencimento;
    private String cvv;
    private String tipo;

    @OneToOne
    @JoinColumn(name = "user_id", updatable = false)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
        private User usuario;

    // @JsonIgnore
    // @Transient 
    // private Long userId;

    public Cartao(CartaoRequestDTO data) {
        this.titular = data.titular();
        this.numero = data.numero();
        this.vencimento = data.vencimento();
        this.cvv = data.cvv();
        this.tipo = data.tipo();
        // this.usuario = data.usuario();
    }
}
