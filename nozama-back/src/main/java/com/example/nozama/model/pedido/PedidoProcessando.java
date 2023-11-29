package com.example.nozama.model.pedido;

public class PedidoProcessando implements EstadoPedido{
    @Override
    public void proximoEstado(Pedido pedido) {
        pedido.setEstado(new PedidoEnviado());
    }

    @Override
    public void estadoAnterior(Pedido pedido) {
        pedido.setEstado(new PedidoNovo());
    }
}
