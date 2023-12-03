package com.example.nozama.model.pagamento;

import com.example.nozama.model.pagamento.cartao.Cartao;
import com.example.nozama.model.user.User;

public class PagamentoCreditoStrategy implements PagamentoStrategy{
  private Cartao cartao;

    @Override
    public String executaPagamento(double valorTotal) {
        if (cartao.getTipo() == "credito"){
          return "Pago com Crédio";
        }
        else {
          return "Compra não concluída";
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
