package com.example.nozama.model.pedido;

public class PedidoEnviado extends EstadoPedido {

    public PedidoEnviado(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void proximoEstado() {
        pedido.setEstado(new PedidoEntregue(pedido));
    }

    @Override
    public void estadoAnterior() {
        pedido.setEstado(new PedidoProcessando(pedido));
    }
}