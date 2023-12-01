package com.example.nozama.model.envioFacade;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import com.example.nozama.model.envio.Envio;
import com.example.nozama.utils.MockUpAPIEnvio;

public class EnvioFacade {
    // Classe criada para aplicar o padrao de projeto Facade.
    /* 
     A ideia geral por tras da classe seria que ela fosse responsável por todo o processamento de dados e importação de classes
     referente ao envio de uma compra, removendo essa responsabilidade da classe Envio.  
    */

    public static Envio enviarPedido(){

        Map <String, String> mapEnvio = MockUpAPIEnvio.enviarPedido();

        Envio envio = new Envio(mapEnvio.get("codigo"), mapEnvio.get("status"));

        return envio;
    }

    public static Rastreio rastrearPedido(String codigo) throws ParseException{

        Map <String, String> mapRastreio = MockUpAPIEnvio.rastrearPedido(codigo);

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataEntrega = formato.parse(mapRastreio.get("previsaoEntrega"));


        Rastreio rastreio = new Rastreio(mapRastreio.get("status"), mapRastreio.get("local"), dataEntrega);

        return rastreio;
    }

    public static String statusPedido(String codigo) throws ParseException{

        return MockUpAPIEnvio.statusPedido(codigo);
    }

}
