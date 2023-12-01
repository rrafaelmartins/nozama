package com.example.nozama.utils;

import java.util.HashMap;
import java.util.Map;

public class MockUpAPIEnvio {
    public static String PREPARANDO = "Preparando";
    public static String ENVIADO = "Enviado";
    public static String ENTREGUE = "Entregue";


    public static Map <String, String> enviarPedido(){
        Map <String, String> pedido = new HashMap<>();

        pedido.put("status", "testEnviado");
        pedido.put("localAtual", "transportadora");
        pedido.put("previsaoEntrega", "31/02/2024");
        pedido.put("status", ENVIADO);


        return pedido;
    }

    public static String statusPedido(String codigoEnvio){

        switch (codigoEnvio) {
            case "testEnviado":
                
                return ENVIADO;
            
            case "testEntregue":
                return ENTREGUE;
        
            default:
                return PREPARANDO;
        }
    }

    public static Map<String, String> rastrearPedido(String codigoEnvio){
        Map <String, String> pedido = new HashMap<>();

        switch (codigoEnvio) {
            case "testEnviado":
                
                pedido.put("localAtual", "transportadora");
                pedido.put("previsaoEntrega", "31/02/2024");
                pedido.put("status", ENVIADO);
            
            case "testEntregue":
                pedido.put("localAtual", "Pedido entregue ao destinatario");
                pedido.put("previsaoEntrega", "04/12/2023");
                pedido.put("status", ENTREGUE);
        
            default:
                pedido.put("localAtual", "O vendedor esta preparando o pedido");
                pedido.put("previsaoEntrega", "06/12/2023");
                pedido.put("status", PREPARANDO);
        }

        return pedido;
    }


}
