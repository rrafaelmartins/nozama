package com.example.nozama.model.pedido;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipoEstado")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PedidoNovo.class, name = "NOVO"),
        @JsonSubTypes.Type(value = PedidoProcessando.class, name = "PROCESSANDO"),
        @JsonSubTypes.Type(value = PedidoEnviado.class, name = "ENVIADO"),
        @JsonSubTypes.Type(value = PedidoEntregue.class, name = "ENTREGUE"),
        // Adicione mais subtipos conforme necessário
})

public abstract class EstadoPedido {
    protected Pedido pedido;

    @Override
    public String toString() {
        return this.getClass().getSimpleName(); // Retorna o nome da classe como nome do estado
    }
    public EstadoPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public abstract void proximoEstado();
    public abstract void estadoAnterior();
}