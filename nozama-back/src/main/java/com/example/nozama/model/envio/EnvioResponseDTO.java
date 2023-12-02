package com.example.nozama.model.envio;

import java.util.Date;

import com.example.nozama.model.envioFacade.Rastreio;

public record EnvioResponseDTO(String status, String local,  Date previsaoEntrega ) {
    public EnvioResponseDTO(Rastreio rastreio) {
        this(rastreio.getStatus(), rastreio.getStatus(), rastreio.getPrevisaoEntrega());
    }
}
