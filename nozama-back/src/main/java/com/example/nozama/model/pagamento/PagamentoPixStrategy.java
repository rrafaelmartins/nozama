package com.example.nozama.model.pagamento;
import java.util.UUID;

import com.example.nozama.model.user.User;
public class PagamentoPixStrategy implements PagamentoStrategy{
    private String codigoPix = geraCodigoPix();

    @Override
    public String executaPagamento(double valorTotal) {
        // simulação do pagamento via código gerado!
        
        return "Pago com PIX";
    }

    @Override
    public boolean verificaInfo(User usuario){
        return true;
    }

    private String geraCodigoPix(){
        UUID codigoAleatorio = UUID.randomUUID();
        return codigoAleatorio.toString().replaceAll("_", "");
    }


}