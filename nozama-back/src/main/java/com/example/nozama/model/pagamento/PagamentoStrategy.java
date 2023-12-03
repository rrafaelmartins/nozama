package com.example.nozama.model.pagamento;

import com.example.nozama.model.user.User;

public interface PagamentoStrategy {
    PagamentoResponseStatus executaPagamento(double valorTotal);
    boolean verificaInfo(User usuario);
}
