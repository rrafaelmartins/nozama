package com.example.nozama.model.pedido;

public class PedidoNovo extends EstadoPedido {

    public PedidoNovo(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void proximoEstado() {
        pedido.setEstado(new PedidoProcessando(pedido));
    }

    @Override
    public void estadoAnterior() {
        // Talvez não tenha estado anterior
    }
}