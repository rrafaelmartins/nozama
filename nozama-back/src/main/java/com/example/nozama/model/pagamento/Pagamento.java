package com.example.nozama.model.pagamento;
import com.example.nozama.model.carrinho.Carrinho;
import com.example.nozama.model.user.User;
import jakarta.persistence.*;
import lombok.*;
@Table(name = "pagamento")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private PagamentoStrategy strategy;

    @ManyToOne
    private User user;

    @ManyToOne
    private Carrinho carrinho;

    public Pagamento(PagamentoRequestDTO data) {
        this.strategy = new PagamentoCreditoStrategy();
        this.user = data.user();
        this.carrinho = data.carrinho();
    }

    public void setStrategy(PagamentoStrategy strategy) {
        this.strategy = strategy;
    }

    public PagamentoResponseStatus processaPagamento (){
        double valorCompra = carrinho.calculaTotalCarrinho();
        if (strategy.verificaInfo(user)){
            return strategy.executaPagamento(valorCompra);
        }
        return new PagamentoResponseStatus(400, "Erro no pagamento");
    }
}
