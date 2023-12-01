package com.example.nozama.model.envioFacade;

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

    public String getStatus() {
        return this.status;
    }

    public String getLocal() {
        return this.local;
    }

    public Date getPrevisaoEntrega() {
        return this.previsaoEntrega;
    }
}
