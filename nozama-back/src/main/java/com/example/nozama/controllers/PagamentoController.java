package com.example.nozama.controllers;

import com.example.nozama.model.pagamento.Pagamento;
import com.example.nozama.model.pagamento.PagamentoRequestDTO;
import com.example.nozama.model.pedido.Pedido;
import com.example.nozama.services.PagamentoService;
import com.example.nozama.services.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;
    
    @Autowired
    private PedidoService pedidoService;
    

    @GetMapping
    public List<Pagamento> listarTodos() {
        return pagamentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pagamento> obterPorId(@PathVariable Long id) {
        return pagamentoService.obterPorId(id);
    }

    @PostMapping()
    public Pagamento salvar(@RequestBody PagamentoRequestDTO data) {
        Pagamento pagamento = new Pagamento(data);
        Pedido pedido = new Pedido();
        pedido.setProdutos(data.carrinho().getProdutos());
        pedido.setUserId(data.user().getId());
        pedidoService.salvar(pedido);
        return pagamentoService.salvar(pagamento);
    }

}