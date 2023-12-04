package com.example.nozama.controllers;

import com.example.nozama.model.pagamento.Pagamento;
import com.example.nozama.services.CartaoService;
import com.example.nozama.services.PagamentoService;

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

    @GetMapping
    public List<Pagamento> listarTodos() {
        return pagamentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pagamento> obterPorId(@PathVariable Long id) {
        return pagamentoService.obterPorId(id);
    }

    @PostMapping()
    public String salvar(@RequestBody PagamentoRequestDTO data) {

    }

}