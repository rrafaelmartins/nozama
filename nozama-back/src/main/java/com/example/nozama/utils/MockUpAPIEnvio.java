package com.example.nozama.utils;

import java.util.HashMap;
import java.util.Map;

public class MockUpAPIEnvio {

    private static MockUpAPIEnvio instance;

    public static String PREPARANDO = "Preparando";
    public static String ENVIADO = "Enviado";
    public static String ENTREGUE = "Entregue";

    private MockUpAPIEnvio() {
    }

    public static MockUpAPIEnvio getInstance() {
        if (instance == null) {
            instance = new MockUpAPIEnvio();
        }
        return instance;
    }


    public Map <String, String> enviarPedido(){
        Map <String, String> pedido = new HashMap<>();

        pedido.put("codigo", "testEnviado");
        pedido.put("localAtual", "transportadora");
        pedido.put("previsaoEntrega", "31/02/2024");
        pedido.put("status", ENVIADO);


        return pedido;
    }

    public String statusPedido(String codigoEnvio){

        switch (codigoEnvio) {
            case "testEnviado":
                
                return ENVIADO;
            
            case "testEntregue":
                return ENTREGUE;
        
            default:
                return PREPARANDO;
        }
    }

    public Map<String, String> rastrearPedido(String codigoEnvio){
        Map <String, String> pedido = new HashMap<>();

        System.out.println(codigoEnvio);
        if (codigoEnvio.equals("testEnviado")){
            
            pedido.put("localAtual", "Chegou no centro logístico: Rio de Janeiro ");
            pedido.put("previsaoEntrega", "10/12/2024");
            pedido.put("status", ENVIADO);
        }else if( codigoEnvio.equals("testEntregue")){
            pedido.put("localAtual", "Pedido entregue ao destinatario");
            pedido.put("previsaoEntrega", "04/12/2023");
            pedido.put("status", ENTREGUE);
        }else{
            pedido.put("localAtual", "O vendedor está preparando o pedido");
            pedido.put("previsaoEntrega", "06/12/2023");
            pedido.put("status", PREPARANDO);
        }
        return pedido;
    }


}
