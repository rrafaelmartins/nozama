package com.example.nozama.model.EnvioFacade;

import java.util.Date;

public class Rastreio {
    public String status;

    public String local;

    public Date previsaoEntrega;

    public Rastreio(String status, String local, Date previsaoEntrega) {
        this.status = status;
        this.local = local;
        this.previsaoEntrega = previsaoEntrega;
    }
}
