package com.example.nozama.model.EnvioFacade;

import java.util.Date;
public class Rastreio {
    public String status;

    public String local;

    public String previsaoEntrega;

    public Rastreio(String status, String local, String previsaoEntrega) {
        this.status = status;
        this.local = local;
        this.previsaoEntrega = previsaoEntrega;
    }

    public String getStatus() {
        return this.status;
    }

    public String getLocal() {
        return this.local;
    }

    public String getPrevisaoEntrega() {
        return this.previsaoEntrega;
    }
}
