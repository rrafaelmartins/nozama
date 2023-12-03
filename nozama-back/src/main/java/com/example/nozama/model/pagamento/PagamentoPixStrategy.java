package com.example.nozama.model.pagamento;
import java.util.UUID;
public class PagamentoPixStrategy implements PagamentoStrategy{
    private String codigoPix = geraCodigoPix();

    @Override
    public boolean executaPagamento(double valorTotal) {
        // simulação do pagamento via código gerado!

        return true;
    }

    @Override
    public void verificaInfo() {

    }

    private String geraCodigoPix(){
        UUID codigoAleatorio = UUID.randomUUID();
        return codigoAleatorio.toString().replaceAll("_", "");
    }

}
