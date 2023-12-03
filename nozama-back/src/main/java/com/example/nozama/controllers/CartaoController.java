package com.example.nozama.controllers;

import com.example.nozama.model.pagamento.cartao.Cartao;
import com.example.nozama.model.pagamento.cartao.CartaoRequestDTO;
import com.example.nozama.services.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {
    @Autowired
    private CartaoService cartaoService;

    @GetMapping
    public List<Cartao> listarTodos() {
        return cartaoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Cartao> obterPorId(@PathVariable Long id) {
        return cartaoService.obterPorId(id);
    }

    @PostMapping()
    public Cartao salvar(@RequestBody CartaoRequestDTO data) {
        Cartao cartao = new Cartao(data);
        return cartaoService.salvar(cartao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        cartaoService.deletar(id);
    }
}