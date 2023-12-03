package com.example.nozama.model.pagamento;

import com.example.nozama.model.pagamento.cartao.Cartao;
import com.example.nozama.model.user.User;

public class PagamentoDebitoStrategy implements PagamentoStrategy{
  private Cartao cartao;

    @Override
    public String executaPagamento(double valorTotal) {
        // Lógica do Pagamento
        return "Pago com Débito";
    }

    @Override
    public boolean verificaInfo(User usuario) {
        return true;

    }
}
