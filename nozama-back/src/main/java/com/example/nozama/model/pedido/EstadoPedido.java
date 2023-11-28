package com.example.nozama.model.pedido;

public interface EstadoPedido {
    void proximoEstado(Pedido pedido);

    void estadoAnterior(Pedido pedido);

}
