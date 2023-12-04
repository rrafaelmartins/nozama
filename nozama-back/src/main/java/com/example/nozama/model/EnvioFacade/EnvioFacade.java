package com.example.nozama.model.EnvioFacade;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import com.example.nozama.model.envio.Envio;
import com.example.nozama.utils.MockUpAPIEnvio;

public class EnvioFacade {
    /* Classe criada para aplicar o padrao de projeto Facade.
    *
        A ideia geral por tras da classe EnvioFacade seria que ela fosse responsavel por todo o processamento de dados e conexao com a(s) API
     referente ao envio de uma compra.  
        Deste modo, a classe Envio nao precisaria ter conhecimento sobre nenhuma classe ou estrutura referente a API de rastreio.  
     * 
     */

    static MockUpAPIEnvio apiEnvio = MockUpAPIEnvio.getInstance();

    public static Envio enviarPedido(){

        Map <String, String> mapEnvio = apiEnvio.enviarPedido();

        Envio envio = new Envio(mapEnvio.get("codigo"));

        return envio;
    }

    public static Rastreio rastrearPedido(String codigo) throws ParseException{

        Map <String, String> mapRastreio = apiEnvio.rastrearPedido(codigo);

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataEntrega = formato.parse(mapRastreio.get("previsaoEntrega"));


        Rastreio rastreio = new Rastreio(mapRastreio.get("status"), mapRastreio.get("localAtual"), dataEntrega);

        return rastreio;
    }

    public static String statusPedido(String codigo) throws ParseException{

        return apiEnvio.statusPedido(codigo);
    }

}
