package com.example.nozama.model.pagamento;

public class PagamentoPixStrategy implements PagamentoStrategy{
    private String codigoPix;

    @Override
    public boolean executaPagamento(double valorTotal) {
        // Checkar se o código PIX foi pago.
        return true;
    }

    @Override
    public void verificaInfo() {
        geraCodigoPix();
        // implementar o resto.
    }

    private void geraCodigoPix(){
        this.codigoPix = "";
    }
}
