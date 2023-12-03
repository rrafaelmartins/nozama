package com.example.nozama.model.pagamento;

import com.example.nozama.model.pagamento.cartao.Cartao;
import com.example.nozama.model.user.User;

public class PagamentoDebitoStrategy implements PagamentoStrategy{
  private Cartao cartao;

    @Override
    public String executaPagamento(double valorTotal) {
        if (cartao.getTipo() == "debito"){
          return "Pago com Débito";

        }
        else {
          return "Compra não concluída";
        }
    }

    @Override
    public boolean verificaInfo(User usuario) {
      this.cartao = usuario.getCartao();
        return true;

    }
}
