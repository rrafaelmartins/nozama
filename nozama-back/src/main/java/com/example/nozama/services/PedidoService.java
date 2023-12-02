package com.example.nozama.services;

import com.example.nozama.model.pedido.Pedido;
import com.example.nozama.model.pedido.PedidoRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    //CRUD
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obterPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    @Transactional
    public Pedido salvarPedido(Pedido pedido) {
            return pedidoRepository.save(pedido);
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }


}
