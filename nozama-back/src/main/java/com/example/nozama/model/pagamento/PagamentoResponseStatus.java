package com.example.nozama.model.pagamento;

public class PagamentoResponseStatus {
    private int codigoStatus;
    private String mensagem;

    public PagamentoResponseStatus(int codigoStatus, String mensagem) {
        this.codigoStatus = codigoStatus;
        this.mensagem = mensagem;
    }

    public int getCodigoStatus() {
        return codigoStatus;
    }

    public String getMensagem() {
        return mensagem;
    }
}

