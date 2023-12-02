package com.example.nozama.model.pagamento;

public class PagamentoDebitoStrategy implements PagamentoStrategy{
    @Override
    public boolean executaPagamento(double valorTotal) {
        // Lógica do Pagamento
        return true;
    }

    @Override
    public void verificaInfo() {
        
      // Implementar a lógica do cartão
    }
}
