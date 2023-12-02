package com.example.nozama.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// CarrinhoService.java
@Service
public class CarrinhoService {
       @Autowired
    private PedidoRepository pedidoRepository;
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }
    public Optional<Pedido> obterPorId(Long id) {
        return pedidoRepository.findById(id);
    }
    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

    // Implemente os métodos para atualizar, recuperar e deletar itens do carrinho
}
