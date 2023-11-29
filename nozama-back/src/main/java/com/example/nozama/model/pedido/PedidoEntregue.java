package com.example.nozama.model.pedido;

public class PedidoEntregue implements EstadoPedido{
    @Override
    public void proximoEstado(Pedido pedido) {
        // Não implementa, pois é o último estado
    }
    @Override
    public void estadoAnterior(Pedido pedido) {
        pedido.setEstado(new PedidoEnviado());
    }
}
