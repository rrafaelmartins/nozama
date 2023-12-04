package com.example.nozama.model.envio;

import java.util.Date;

import com.example.nozama.model.EnvioFacade.Rastreio;

public record EnvioResponseDTO(String status, String local,  String previsaoEntrega ) {
    public EnvioResponseDTO(Rastreio rastreio) {
        this(rastreio.getStatus(), rastreio.getStatus(), rastreio.getPrevisaoEntrega());
    }
}
