package com.example.nozama.controllers;

import com.example.nozama.model.produto.Produto;
import com.example.nozama.model.produto.ProdutoRequestDTO;
import com.example.nozama.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

 @CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterPorId(@PathVariable Long id) {
        return produtoService.obterPorId(id);
    }

    @PostMapping()
    public Produto salvar(@RequestBody ProdutoRequestDTO data) {
        Produto produto = new Produto(data);
        return produtoService.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }
}