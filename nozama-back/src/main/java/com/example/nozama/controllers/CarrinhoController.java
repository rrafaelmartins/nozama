package com.example.nozama.controllers;

import com.example.nozama.model.carrinho.Carrinho;
import com.example.nozama.model.carrinho.CarrinhoRequestDTO;
import com.example.nozama.model.carrinho.ProdutoCarrinho;
import com.example.nozama.model.carrinho.ProdutoCarrinhoRequestDTO;
import com.example.nozama.model.carrinho.CarrinhoObserver.CarrinhoObserver;
import com.example.nozama.model.produto.Produto;
import com.example.nozama.services.CarrinhoService;
import com.example.nozama.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Carrinho> listarTodos() {
        return carrinhoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Carrinho> obterPorId(@PathVariable Long id) {
        return carrinhoService.obterPorId(id);
    }

    @PostMapping()
    public Carrinho salvar(@RequestBody CarrinhoRequestDTO data) {
        Carrinho carrinho = new Carrinho(data);
        return carrinhoService.salvar(carrinho);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
       carrinhoService.deletar(id);
    }
     
    @PostMapping("/{id}/add-produto")
    public void adicionarProduto(@PathVariable Long id, @RequestBody ProdutoCarrinhoRequestDTO data){
        
        carrinhoService.adicionarProduto(id, data.produto_id(), data.quantidade());

    }
}