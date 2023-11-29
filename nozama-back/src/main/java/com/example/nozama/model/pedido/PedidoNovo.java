package com.example.nozama.model.pedido;

public class PedidoNovo implements EstadoPedido{
    @Override
    public void proximoEstado(Pedido pedido) {
        pedido.setEstado(new PedidoProcessando());
    }

    @Override
    public void estadoAnterior(Pedido pedido) {
        // Não implementa, pois é o primeiro estado
    }
}
