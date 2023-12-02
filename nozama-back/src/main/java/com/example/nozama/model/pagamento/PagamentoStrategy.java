package com.example.nozama.model.pagamento;

public interface PagamentoStrategy {
    boolean executaPagamento(double valorTotal);
    void verificaInfo();
}
