package com.example.nozama.model.pagamento;

import com.example.nozama.model.pagamento.cartao.Cartao;
import com.example.nozama.model.user.User;

public class PagamentoCreditoStrategy implements PagamentoStrategy{
  private Cartao cartao;

    @Override
    public PagamentoResponseStatus executaPagamento(double valorTotal) {
        if (cartao.getTipo() == "credito"){
          return new PagamentoResponseStatus(200, "Pago com Crédito");
        }
        else {
          return new PagamentoResponseStatus(400, "Erro no pagamento com Crédito");
        }
    }

    @Override
    public boolean verificaInfo(User usuario) {
      Cartao usuarioCartao = usuario.getCartao();
      if (usuarioCartao != null){
        this.cartao = usuarioCartao;
        return true;
      }
      return false;
    }
}
