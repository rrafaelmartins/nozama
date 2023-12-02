package com.example.nozama.model.pedido;

public class PedidoEntregue extends EstadoPedido {

    public PedidoEntregue(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void proximoEstado() {
        // Talvez final do ciclo de vida do pedido, não muda mais
    }

    @Override
    public void estadoAnterior() {
        // Geralmente, um pedido entregue não volta a estados anteriores
    }
}