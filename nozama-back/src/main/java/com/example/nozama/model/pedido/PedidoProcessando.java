package com.example.nozama.model.pedido;

public class PedidoProcessando extends EstadoPedido {

    public PedidoProcessando(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void proximoEstado() {
        pedido.setEstado(new PedidoEnviado(pedido));
    }

    @Override
    public void estadoAnterior() {
        pedido.setEstado(new PedidoNovo(pedido));
    }
}