package com.example.nozama.services;

import com.example.nozama.model.pagamento.Pagamento;
import com.example.nozama.model.pagamento.PagamentoRepository;
import com.example.nozama.model.pedido.Pedido;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoService pedidoService;

    //CRUD
    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }

    public Optional<Pagamento> obterPorId(Long id) {
        return pagamentoRepository.findById(id);
    }

    @Transactional
    public Pagamento salvar(Pagamento pagamento) {
        // Pedido pedido = new Pedido(null, null, null, null, null, null);
        //     pedidoService.salvar(pedido);
            return pagamentoRepository.save(pagamento);
    }

    public void deletar(Long id) {
        pagamentoRepository.deleteById(id);
    }


}
