package com.example.nozama.model.pagamento.cartao;
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
    private Long id;

    private String titular;
    private String numero;
    private String vencimento;
    private String cvv;

    public Cartao(CartaoRequestDTO data) {
        this.titular = data.titular();
        this.numero = data.numero();
        this.vencimento = data.vencimento();
        this.cvv = data.cvv();

    }
}
