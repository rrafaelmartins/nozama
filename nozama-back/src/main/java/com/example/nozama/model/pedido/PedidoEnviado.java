package com.example.nozama.model.pedido;

public class PedidoEnviado implements EstadoPedido{
    @Override
    public void proximoEstado(Pedido pedido) {
        pedido.setEstado(new PedidoEntregue());
    }
    @Override
    public void estadoAnterior(Pedido pedido) {
        pedido.setEstado(new PedidoProcessando());
    }
}
